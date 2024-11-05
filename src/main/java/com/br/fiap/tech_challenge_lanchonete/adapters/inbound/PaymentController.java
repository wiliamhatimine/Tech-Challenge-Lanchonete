package com.br.fiap.tech_challenge_lanchonete.adapters.inbound;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.fiap.tech_challenge_lanchonete.adapters.outbound.PaymentAdapter;
import com.br.fiap.tech_challenge_lanchonete.adapters.outbound.QueueAdapter;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Payment;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Queue;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.enums.PaymentStatusEnums;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Pagamento", description = "Controle de pagamentos")
@RestController
@RequestMapping("/payment/api/v1")
public class PaymentController {

	Logger log = LoggerFactory.getLogger(PaymentController.class);
	
	@Autowired
	private PaymentAdapter paymentAdapter;
	@Autowired private QueueAdapter queueAdapter;
	
	@GetMapping("/get-payment/{idOrder}")
	@ApiResponse(responseCode = "200", description = "Pagamento obtido com sucesso", content = { @Content(mediaType = "application/json",
    schema = @Schema(implementation = Payment.class)) })
	@Operation(summary = "Obter pedido pelo codigo do cliente")
	public ResponseEntity<Payment> getPayment(@PathVariable("idOrder") Long idOrder){
		Payment payment = paymentAdapter.getPaymentByOrderId(idOrder);
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(payment);
	}
	
	@PutMapping("/pay-order/{idOrder}")
	@ApiResponse(responseCode = "200", description = "Pagamento feito com sucesso", content = { @Content(mediaType = "application/json",
	 schema = @Schema(implementation = Payment.class)) })
	@Operation(summary = "Realizar pagamento pelo codigo do pedido")
	public ResponseEntity<Payment> payOrder(@PathVariable("idOrder") Long idOrder){
		Payment payment = paymentAdapter.changePaymentStatus(idOrder, PaymentStatusEnums.PAGO);
		Queue queue = queueAdapter.checkOrderStatus(payment.getIdOrder());
		if(paymentAdapter.getPaymentByOrderId(idOrder).getPaymentStatus() == PaymentStatusEnums.PAGO) {
			queueAdapter.moveToPreparing(queue.getOrderId());
		}
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(payment);
	}
}
