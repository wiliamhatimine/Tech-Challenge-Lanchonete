package com.br.fiap.tech_challenge_lanchonete.application.usecases.products;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.br.fiap.tech_challenge_lanchonete.domain.Product;

public interface ManagerProductsUseCase {
	Product save(Product product);
	Product edit(Product product);
	void delete(Long productId);
	List<Product> getProductByCate(String categorie);
}
