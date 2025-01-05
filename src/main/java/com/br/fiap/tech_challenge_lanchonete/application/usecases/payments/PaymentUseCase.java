package com.br.fiap.tech_challenge_lanchonete.application.usecases.payments;

import com.br.fiap.tech_challenge_lanchonete.domain.Payment;
import com.br.fiap.tech_challenge_lanchonete.domain.enums.PaymentStatusEnums;
import com.br.fiap.tech_challenge_lanchonete.gateway.PaymentRepositoryGateway;

public class PaymentUseCase {

	private final PaymentRepositoryGateway paymentRepositoryGateway;
	
	public PaymentUseCase(PaymentRepositoryGateway paymentRepositoryGateway) {
		this.paymentRepositoryGateway = paymentRepositoryGateway;
	}
	public Payment createPayment(Long idOrder, Long idCustomer) {
		return paymentRepositoryGateway.createPayment(idOrder, idCustomer);
	};
	public Payment changePaymentStatus(Long idPayment, PaymentStatusEnums paymentStatus) {
		return paymentRepositoryGateway.changePaymentStatus(idPayment, paymentStatus);
	};
	public Payment getPaymentByCustomerId(Long idCustomer) {
		return paymentRepositoryGateway.getPaymentByCustomerId(idCustomer);
	};
	public Payment getPaymentByOrderId(Long orderId) {
		return paymentRepositoryGateway.getPaymentByOrderId(orderId);
	};
	public Payment getStatusByPaymentId(Long idPayment) {
		return paymentRepositoryGateway.getStatusByPaymentId(idPayment);
	};
}
