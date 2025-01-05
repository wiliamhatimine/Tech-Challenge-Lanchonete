package com.br.fiap.tech_challenge_lanchonete.infra.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.fiap.tech_challenge_lanchonete.domain.Customer;
import com.br.fiap.tech_challenge_lanchonete.infra.persistence.entities.CustomersEntity;

public interface CustomersRepository extends JpaRepository<CustomersEntity, Long> {
	
}
