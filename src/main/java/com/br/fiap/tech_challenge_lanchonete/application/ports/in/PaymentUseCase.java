package com.br.fiap.tech_challenge_lanchonete.application.ports.in;

import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Payment;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.enums.PaymentStatusEnums;

public interface PaymentUseCase {

	Payment createPayment(Long idOrder);
	Payment doPayment(Long idPayment, PaymentStatusEnums paymentStatus);
	Payment getPayment(Long idPayment);
	Payment getPaymentByOrderId(Long idOrder);
}
