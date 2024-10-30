package com.br.fiap.tech_challenge_lanchonete.application.core.domain.service;

import java.util.List;

import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Product;
import com.br.fiap.tech_challenge_lanchonete.application.ports.in.ManagerProductsUseCase;
import com.br.fiap.tech_challenge_lanchonete.application.ports.out.ProductPort;

public class ProductsService implements ManagerProductsUseCase{

	private ProductPort productPort;
	
	@Override
	public Product save(Product product) {
		return productPort.save(product);
	}

	@Override
	public Product edit(Product product) {
		return productPort.edit(product);
	}

	@Override
	public void delete(Long productId) {
		productPort.delete(productId);		
	}

	@Override
	public List<Product> getProductByCate(String categorie) {
		return productPort.productByCategorie(categorie);
	}

}
