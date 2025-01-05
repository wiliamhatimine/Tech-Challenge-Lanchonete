package com.br.fiap.tech_challenge_lanchonete.infra.services.payments;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.br.fiap.tech_challenge_lanchonete.application.usecases.payments.PaymentUseCase;
import com.br.fiap.tech_challenge_lanchonete.domain.Payment;
import com.br.fiap.tech_challenge_lanchonete.domain.enums.PaymentStatusEnums;

@Service
public class PaymentService{

	Logger logger = LoggerFactory.getLogger(PaymentService.class);
	
	private final PaymentUseCase paymentUseCase;
	
	public PaymentService(PaymentUseCase paymentUseCase) {
		this.paymentUseCase = paymentUseCase;
	}

	public Payment createPayment(Long idOrder, Long idCustomer) {
		return paymentUseCase.createPayment(idOrder, idCustomer);
	}

	public Payment changePaymentStatus(Long idOrder, PaymentStatusEnums paymentStatus) {
		return paymentUseCase.changePaymentStatus(idOrder, paymentStatus);
	}

	public Payment getPaymentByCustomerId(Long customerId) {
		return paymentUseCase.getPaymentByCustomerId(customerId);
	}

	public Payment getPaymentByOrderId(Long orderId) {
		return paymentUseCase.getPaymentByOrderId(orderId);
	}
	public Payment getStatusByPaymentId(Long paymentId) {
		return paymentUseCase.getStatusByPaymentId(paymentId);
	}
	
}
