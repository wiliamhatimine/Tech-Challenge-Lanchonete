package com.br.fiap.tech_challenge_lanchonete.infra.services.products;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.br.fiap.tech_challenge_lanchonete.domain.Product;
import com.br.fiap.tech_challenge_lanchonete.domain.enums.CategorieEnums;
import com.br.fiap.tech_challenge_lanchonete.gateway.ProductRepositoryGateway;
import com.br.fiap.tech_challenge_lanchonete.infra.persistence.entities.ProductsEntity;
import com.br.fiap.tech_challenge_lanchonete.infra.persistence.repositories.ProductsRepository;

@Component
public class ProductsService implements ProductRepositoryGateway {

	Logger logger = LoggerFactory.getLogger(ProductsService.class);
	
	private ProductsRepository productsRepository;
	
	public ProductsService(ProductsRepository productsRepository) {
		this.productsRepository = productsRepository;
	}

	@Override
	public Product save(Product product) {
		ProductsEntity productEntity = new ProductsEntity();
		productEntity.setName(product.getName());
		productEntity.setCategorie(product.getCategorie());
		productEntity.setPrice(product.getPrice());
		productEntity.setDescription(product.getDescription());
		productEntity.setImage(product.getImage());
		return productsRepository.save(productEntity).toModel();
	}

	@Override
	public Product edit(Product product) {
		ProductsEntity productEntity = new ProductsEntity();
		productEntity.setIdProduct(product.getIdProduct());
		productEntity.setName(product.getName());
		productEntity.setCategorie(product.getCategorie());
		productEntity.setPrice(product.getPrice());
		productEntity.setDescription(product.getDescription());
		productEntity.setImage(product.getImage());
		return productsRepository.save(productEntity).toModel();
	}

	@Override
	public void delete(Long productId) {
		productsRepository.deleteById(productId);
	}
 
	@Override
	public List<Product> productByCategorie(String categorie) {
			List<ProductsEntity> listProducts = productsRepository.findByCategorie(CategorieEnums.valueOf(categorie));
		return listProducts.stream().map(product ->{
			return product.toModel();
		}).toList();
	}

	@Override
	public List<Product> getAllProducts() {
		return productsRepository.findAll().stream().map(product ->{ 
			return product.toModel();
		}).toList();
	}

}
