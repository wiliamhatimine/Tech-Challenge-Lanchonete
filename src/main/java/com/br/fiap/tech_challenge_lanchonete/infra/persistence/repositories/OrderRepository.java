package com.br.fiap.tech_challenge_lanchonete.infra.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.fiap.tech_challenge_lanchonete.infra.persistence.entities.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

}
