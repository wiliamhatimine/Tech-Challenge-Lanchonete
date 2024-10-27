package com.br.fiap.tech_challenge_lanchonete.adapters.outbound.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.fiap.tech_challenge_lanchonete.adapters.outbound.entity.PaymentEntity;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Payment;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long>{
	
	PaymentEntity findByIdOrder(Long idOrder);

}
