package com.br.fiap.tech_challenge_lanchonete.adapters.outbound;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.br.fiap.tech_challenge_lanchonete.adapters.outbound.entity.PaymentEntity;
import com.br.fiap.tech_challenge_lanchonete.adapters.outbound.repository.PaymentRepository;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Payment;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.enums.PaymentStatusEnums;
import com.br.fiap.tech_challenge_lanchonete.application.ports.out.PaymentPort;

@Component
public class PaymentAdapter implements PaymentPort{

	Logger logger = LoggerFactory.getLogger(PaymentAdapter.class);
	
	private PaymentRepository paymentRepository;
	
	public PaymentAdapter(PaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}

	@Override
	public Payment createPayment(Long idOrder) {
		PaymentEntity entity = new PaymentEntity();
		entity.setIdOrder(idOrder);
		entity.setUpdatedStatus(LocalDateTime.now());
		entity.setStatus(PaymentStatusEnums.AGUARDANDO_PAGAMENTO);
		return paymentRepository.save(entity).toModel();
	}

	@Override
	public Payment changePaymentStatus(Long idOrder, PaymentStatusEnums paymentStatus) {
		PaymentEntity entity = paymentRepository.findByIdOrder(idOrder);
		entity.setUpdatedStatus(LocalDateTime.now());
		entity.setStatus(paymentStatus);
		return paymentRepository.save(entity).toModel();
	}

	@Override
	public Payment getPaymentFromIdOrder(Long idOrder) {
		return paymentRepository.findByIdOrder(idOrder).toModel();
	}

	@Override
	public Payment getPayment(Long idPayment) {
		return paymentRepository.findById(idPayment).get().toModel();
	}
}
