package com.br.fiap.tech_challenge_lanchonete.adapters.inbound;

import java.util.List;
import java.util.NoSuchElementException;
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
import com.br.fiap.tech_challenge_lanchonete.adapters.outbound.ProductsAdapter;
import com.br.fiap.tech_challenge_lanchonete.adapters.outbound.QueueAdapter;
import com.br.fiap.tech_challenge_lanchonete.adapters.outbound.exceptions.ExceptionResponse;
import com.br.fiap.tech_challenge_lanchonete.adapters.outbound.exceptions.ProductNotFoundException;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Order;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Product;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.ProductOrder;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Queue;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.enums.QueueEnums;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Pedidos", description = "Gerenciamento de pedidos")
@RestController
@RequestMapping("/order/api/v1")
public class OrderController {

	Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired private OrdersAdapter ordersAdapter;
	@Autowired private QueueAdapter queueAdapter;
	@Autowired private PaymentAdapter paymentAdapter;
	@Autowired private ProductsAdapter productsAdapter;

	@PostMapping("/create")
	@Operation(summary = "Criar pedido")
	@ApiResponse(responseCode = "200", description = "Pedido criado com sucesso", content = { @Content(mediaType = "application/json",
	 schema = @Schema(implementation = Order.class)) })
	@ApiResponse(responseCode = "404", description = "Lista de produtos inválida", content = { @Content(mediaType = "application/json",
	 schema = @Schema(implementation = ExceptionResponse.class)) })
	public ResponseEntity<Order> createOrder(@RequestParam(required = false) Long idCustomer,
			@RequestBody List<ProductOrder> products) throws Exception {
		Order order = new Order();
		try {
			products = products.stream().map(productOrder -> {
				Product prod = productsAdapter.getAllProducts().stream()
				.filter(
						product -> Objects.equals(product.getIdProduct(), productOrder.getIdProduct()))
				.findAny()
				.get();
				return new ProductOrder(prod.getIdProduct(),prod.getPrice(), prod.getName(), productOrder.getQuantity());
			}).toList();
			if(!products.isEmpty()) {
				order = ordersAdapter.saveOrder(Objects.nonNull(idCustomer) ? idCustomer : null, products);
					queueAdapter.clientMakeOrder(order.getIdOrder());
					paymentAdapter.createPayment(order.getIdOrder(), idCustomer);
					logger.info("Pedido realizado com sucesso");
			}
		} catch (NoSuchElementException e) {
			logger.error("Erro ao cadastrar");
			throw new ProductNotFoundException("Lista de produtos inválida !");
		}
		return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(order);
	}
	
	@GetMapping("/all-orders")
	@Operation(summary = "Listar todos os pedidos")
	@ApiResponse(responseCode = "200", description = "Todos os pedidos listados com sucesso", content = { @Content(mediaType = "application/json",
			array = @ArraySchema( schema = @Schema(implementation = Order.class)))})
	public ResponseEntity<List<Order>> getAllOrders(){
		List<Order> listOrders = ordersAdapter.getOrders();
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(listOrders);
	}
	
	@GetMapping("/queue-orders")
	@Operation(summary = "Listar todos os pedidos na fila")
	@ApiResponse(responseCode = "200", description = "Todos os status dos pedidos na fila listados com sucesso", content = { @Content(mediaType = "application/json",
			array = @ArraySchema( schema = @Schema(implementation = Queue.class)))})
	public ResponseEntity<List<Queue>> getAllClientOrder(@Parameter(description = "Status que deseja remover da lista de pedidos na fila") @RequestParam(required = false) QueueEnums status){
		List<Queue> listClientOrders = queueAdapter.listClientOrders(status);
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(listClientOrders);
	}
	
	@PutMapping("/completed/{idOrder}")
	@Operation(summary = "Atualizar pedido para Pronto")
	@ApiResponse(responseCode = "200", description = "Pedido pronto com sucesso", content = { @Content(mediaType = "application/json",
	 schema = @Schema(implementation = String.class)) })
	public ResponseEntity<String> completedOrder(@PathVariable("idOrder") Long idOrder){
		queueAdapter.kitchenCompletedOrder(idOrder);
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).body("Pedido Pronto");
	}
	
	@PutMapping("/withdrawn/{idOrder}")
	@Operation(summary = "Atualizar pedido para Finalizado")
	@ApiResponse(responseCode = "200", description = "Pedido finalizado com sucesso", content = { @Content(mediaType = "application/json",
	 schema = @Schema(implementation = String.class)) })
	public ResponseEntity<String> orderWithdrawn(@PathVariable("idOrder") Long idOrder){
		queueAdapter.orderWithdrawn(idOrder);
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).body("Pedido Finalizado");
	}
}
