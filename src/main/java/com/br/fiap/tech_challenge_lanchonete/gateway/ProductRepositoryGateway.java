package com.br.fiap.tech_challenge_lanchonete.gateway;

import java.util.List;

import com.br.fiap.tech_challenge_lanchonete.domain.Product;

public interface ProductRepositoryGateway {
	Product save(Product product);
	Product edit(Product product);
	void delete(Long productId);
	List<Product> productByCategorie(String categorie);
	List<Product> getAllProducts();
}
