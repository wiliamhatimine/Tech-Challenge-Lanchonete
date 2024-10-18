package com.br.fiap.tech_challenge_lanchonete.application.ports.in;

import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Product;

public interface ManagerProductsUseCase {
	Product save(Product product);
	Product edit(Product product);
	void delete(Long productId);
	
}