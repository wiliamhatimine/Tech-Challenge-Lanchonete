package com.br.fiap.tech_challenge_lanchonete.adapters.outbound;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.fiap.tech_challenge_lanchonete.adapters.outbound.entity.ProductsEntity;

public interface ProductsRepository extends JpaRepository<ProductsEntity, Long>{

}
