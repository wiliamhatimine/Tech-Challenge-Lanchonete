package com.br.fiap.tech_challenge_lanchonete.application.core.service;

import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Payment;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.enums.PaymentStatusEnums;
import com.br.fiap.tech_challenge_lanchonete.application.ports.in.PaymentUseCase;
import com.br.fiap.tech_challenge_lanchonete.application.ports.out.PaymentPort;

public class PaymentService implements PaymentUseCase{

	private PaymentPort paymentPort;
	
	@Override
	public Payment createPayment(Long idOrder, Long idCustomer) {
		return paymentPort.createPayment(idOrder, idCustomer);
	}

	@Override
	public Payment changePaymentStatus(Long idPayment, PaymentStatusEnums paymentStatus) {
		return paymentPort.changePaymentStatus(idPayment, paymentStatus);
	}

	@Override
	public Payment getPaymentByCustomerId(Long idCustomer) {
		return paymentPort.getPaymentByCustomerId(idCustomer);
	}

}
