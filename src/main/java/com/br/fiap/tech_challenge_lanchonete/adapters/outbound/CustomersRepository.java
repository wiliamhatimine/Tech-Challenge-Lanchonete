package com.br.fiap.tech_challenge_lanchonete.adapters.outbound;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.fiap.tech_challenge_lanchonete.adapters.outbound.entity.CustomersEntity;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Customer;

public interface CustomersRepository extends JpaRepository<CustomersEntity, Long> {
	
}
