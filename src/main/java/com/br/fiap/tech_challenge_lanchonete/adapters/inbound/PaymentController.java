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
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.enums.PaymentStatusEnums;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.queue.Queue;

@RestController()
@RequestMapping("/payment/api/v1")
public class PaymentController {

	Logger log = LoggerFactory.getLogger(PaymentController.class);
	
	@Autowired
	private PaymentAdapter paymentAdapter;
	@Autowired private QueueAdapter queueAdapter;
	
	@GetMapping("/get-payment/{idPayment}")
	public ResponseEntity<Payment> getPayment(@PathVariable("idPayment") Long idPayment){
		Payment payment = paymentAdapter.getPayment(idPayment);
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(payment);
	}
	
	@PutMapping("/pay-order/{idOrder}")
	public ResponseEntity<Payment> payOrder(@PathVariable("idOrder") Long idOrder){
		Payment payment = paymentAdapter.changePaymentStatus(idOrder, PaymentStatusEnums.PAGO);
		Queue queue = queueAdapter.checkOrderStatus(payment.getIdOrder());
		if(paymentAdapter.getPayment(payment.getIdPayment()).getPaymentStatus() == PaymentStatusEnums.PAGO) {
			queueAdapter.moveToPreparing(queue.getJobId());
		}
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(payment);
	}
}
