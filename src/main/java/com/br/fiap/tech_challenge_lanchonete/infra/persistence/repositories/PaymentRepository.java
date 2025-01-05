package com.br.fiap.tech_challenge_lanchonete.infra.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.fiap.tech_challenge_lanchonete.domain.Payment;
import com.br.fiap.tech_challenge_lanchonete.infra.persistence.entities.PaymentEntity;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long>{
	
	public PaymentEntity findByIdOrder(Long idOrder);

}
