package com.br.fiap.tech_challenge_lanchonete.application.core.services;

import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Payment;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.enums.PaymentStatusEnums;
import com.br.fiap.tech_challenge_lanchonete.application.ports.in.PaymentUseCase;
import com.br.fiap.tech_challenge_lanchonete.application.ports.out.PaymentPort;

public class PaymentService implements PaymentUseCase {

	private PaymentPort paymentPort;
	
	public PaymentService(PaymentPort paymentPort){
		this.paymentPort = paymentPort;
	}
	
	@Override
	public Payment createPayment(Long idOrder) {
		return paymentPort.createPayment(idOrder);
	}

	@Override
	public Payment doPayment(Long idPayment, PaymentStatusEnums paymentStatus) {
		return paymentPort.changePaymentStatus(idPayment, paymentStatus);
	}

	@Override
	public Payment getPayment(Long idPayment) {
		return paymentPort.getPayment(idPayment);
	}

	@Override
	public Payment getPaymentByOrderId(Long idOrder) {
		return paymentPort.getPaymentFromIdOrder(idOrder);
	}

}
