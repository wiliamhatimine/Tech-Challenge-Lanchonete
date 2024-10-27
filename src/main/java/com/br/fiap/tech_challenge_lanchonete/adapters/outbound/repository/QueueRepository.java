package com.br.fiap.tech_challenge_lanchonete.adapters.outbound.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.fiap.tech_challenge_lanchonete.adapters.outbound.entity.QueueEntity;

public interface QueueRepository extends JpaRepository<QueueEntity, Long> {

	QueueEntity findByIdOrder(Long orderId);
}
