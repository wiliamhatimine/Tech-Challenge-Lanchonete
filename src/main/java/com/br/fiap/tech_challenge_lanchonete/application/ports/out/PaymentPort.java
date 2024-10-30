package com.br.fiap.tech_challenge_lanchonete.application.ports.out;

import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Payment;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.enums.PaymentStatusEnums;

public interface PaymentPort {

	Payment createPayment(Long idOrder, Long idCustomer);
	Payment changePaymentStatus(Long idPayment, PaymentStatusEnums paymentStatus);
	Payment getPaymentByCustomerId(Long customerId);
	
}
