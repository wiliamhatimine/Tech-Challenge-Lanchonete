package com.br.fiap.tech_challenge_lanchonete.adapters.outbound;

import java.util.List;

import org.springframework.stereotype.Component;

import com.br.fiap.tech_challenge_lanchonete.adapters.outbound.entity.ProductsEntity;
import com.br.fiap.tech_challenge_lanchonete.adapters.outbound.repository.ProductsRepository;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Product;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.enums.CategorieEnums;
import com.br.fiap.tech_challenge_lanchonete.application.ports.out.ProductPort;

@Component
public class ProductsAdapter implements ProductPort {

	private ProductsRepository productsRepository;
	
	public ProductsAdapter(ProductsRepository productsRepository) {
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

}
