package com.br.fiap.tech_challenge_lanchonete.infra.persistence.jpa.payments;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.br.fiap.tech_challenge_lanchonete.domain.Payment;
import com.br.fiap.tech_challenge_lanchonete.domain.enums.PaymentStatusEnums;
import com.br.fiap.tech_challenge_lanchonete.gateway.PaymentRepositoryGateway;
import com.br.fiap.tech_challenge_lanchonete.infra.persistence.entities.PaymentEntity;
import com.br.fiap.tech_challenge_lanchonete.infra.persistence.repositories.PaymentRepository;

@Component
public class PaymentsRepositoryJpaGateway implements PaymentRepositoryGateway{

	private final PaymentRepository paymentRepository;
	
	public PaymentsRepositoryJpaGateway(PaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}
	

	@Override
	public Payment createPayment(Long idOrder, Long idCustomer) {
		PaymentEntity entity = new PaymentEntity();
		entity.setIdCustomer(idCustomer);
		entity.setIdOrder(idOrder);
		entity.setUpdatedStatus(LocalDateTime.now());
		entity.setStatus(PaymentStatusEnums.AGUARDANDO_PAGAMENTO);
		return paymentRepository.save(entity).toModel();
	}
	
	@Override
	public Payment changePaymentStatus(Long idPayment, PaymentStatusEnums paymentStatus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Payment getPaymentByCustomerId(Long customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Payment getPaymentByOrderId(Long orderId) {
		return paymentRepository.findByIdOrder(orderId).toModel();
	}


	@Override
	public Payment getStatusByPaymentId(Long paymentId) {
		return paymentRepository.findById(paymentId).get().toModel();
	}


}
