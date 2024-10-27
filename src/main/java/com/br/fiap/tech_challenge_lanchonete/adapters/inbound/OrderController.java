package com.br.fiap.tech_challenge_lanchonete.adapters.inbound;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.fiap.tech_challenge_lanchonete.adapters.outbound.OrdersAdapter;
import com.br.fiap.tech_challenge_lanchonete.adapters.outbound.PaymentAdapter;
import com.br.fiap.tech_challenge_lanchonete.adapters.outbound.QueueAdapter;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Order;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.ProductOrder;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.queue.Queue;

@RestController
@RequestMapping("/order/api/v1")
public class OrderController {

	Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired private OrdersAdapter ordersAdapter;
	@Autowired private QueueAdapter queueAdapter;
	@Autowired private PaymentAdapter paymentAdapter;

	@PostMapping("/create")
	public ResponseEntity<Order> createOrder(@RequestParam(required = false) Long idCustomer,
			@RequestBody List<ProductOrder> products) {
		Order order = new Order();
		try {
			order = ordersAdapter.saveOrder(Objects.nonNull(idCustomer) ? idCustomer : null, products);
			queueAdapter.clientMakeOrder(order.getIdOrder());
			paymentAdapter.createPayment(order.getIdOrder());
			logger.info("Pedido realizado com sucesso");
		} catch (Exception e) {
			logger.error("Erro ao cadastrar");
			throw e;
		}
		return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(order);
	}
	
	@GetMapping("/all-orders")
	public ResponseEntity<List<Order>> getAllOrders(){
		List<Order> listOrders = ordersAdapter.getOrders();
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(listOrders);
	}
	
	@GetMapping("/all-client-order")
	public ResponseEntity<List<Queue>> getAllClientOrder(){
		List<Queue> listClientOrders = queueAdapter.listClientOrders();
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(listClientOrders);
	}
	
	@PutMapping("/move-to-preparing/{jobId}")
	public ResponseEntity<String> moveToPreparing(@PathVariable("jobId") Long jobId){
		queueAdapter.moveToPreparing(jobId);
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).body("Em Preparo");
	}
}
