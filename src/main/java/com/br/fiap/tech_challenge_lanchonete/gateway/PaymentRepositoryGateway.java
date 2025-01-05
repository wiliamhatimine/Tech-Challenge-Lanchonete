package com.br.fiap.tech_challenge_lanchonete.gateway;

import com.br.fiap.tech_challenge_lanchonete.domain.Payment;
import com.br.fiap.tech_challenge_lanchonete.domain.enums.PaymentStatusEnums;

public interface PaymentRepositoryGateway {

	Payment createPayment(Long idOrder, Long idCustomer);
	Payment changePaymentStatus(Long idPayment, PaymentStatusEnums paymentStatus);
	Payment getPaymentByCustomerId(Long customerId);
	Payment getPaymentByOrderId(Long orderId);
	Payment getStatusByPaymentId(Long paymentId);
}
