package com.br.fiap.tech_challenge_lanchonete.application.ports.out;

import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Product;

public interface ProductPort {
	Product save(Product product);
	Product edit(Product product);
	void delete(Long productId);
}