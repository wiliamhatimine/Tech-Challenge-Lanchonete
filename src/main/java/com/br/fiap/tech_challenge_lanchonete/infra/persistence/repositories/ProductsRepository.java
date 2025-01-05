package com.br.fiap.tech_challenge_lanchonete.infra.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.fiap.tech_challenge_lanchonete.domain.Product;
import com.br.fiap.tech_challenge_lanchonete.domain.enums.CategorieEnums;
import com.br.fiap.tech_challenge_lanchonete.infra.persistence.entities.ProductsEntity;


public interface ProductsRepository extends JpaRepository<ProductsEntity, Long>{

	List<ProductsEntity> findByCategorie(CategorieEnums categorie);
}
