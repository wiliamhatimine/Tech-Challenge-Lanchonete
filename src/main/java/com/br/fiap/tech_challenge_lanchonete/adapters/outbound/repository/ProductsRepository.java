package com.br.fiap.tech_challenge_lanchonete.adapters.outbound.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.fiap.tech_challenge_lanchonete.adapters.outbound.entity.ProductsEntity;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Product;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.enums.CategorieEnums;


public interface ProductsRepository extends JpaRepository<ProductsEntity, Long>{

	List<ProductsEntity> findByCategorie(CategorieEnums categorie);
}
