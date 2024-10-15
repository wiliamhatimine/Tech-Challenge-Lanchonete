package com.br.fiap.tech_challenge_lanchonete.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.fiap.tech_challenge_lanchonete.db.entity.CustomersEntity;

public interface CustomersRepository extends JpaRepository<CustomersEntity, Long> {
	
	CustomersEntity findByName(String name);
	
}
