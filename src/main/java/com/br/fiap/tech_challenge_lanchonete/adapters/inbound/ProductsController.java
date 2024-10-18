package com.br.fiap.tech_challenge_lanchonete.adapters.inbound;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.fiap.tech_challenge_lanchonete.adapters.outbound.ProductsAdapter;
import com.br.fiap.tech_challenge_lanchonete.adapters.outbound.entity.ProductsEntity;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Product;

@RestController
@RequestMapping("/products/api/v1")
public class ProductsController {
	
	@Autowired
	private ProductsAdapter productsAdapter;
	
	Logger logger = LoggerFactory.getLogger(ProductsController.class);
	
	@PostMapping("/create")
	public ResponseEntity<ProductsEntity> createProduct(@RequestBody Product product){
		try {
			productsAdapter.save(product);
		}catch(Exception e) {
			logger.error("Erro ao cadastrar");
			throw e;
		}
		return ResponseEntity.status(201).build();
	}
	
	@PutMapping("/update")
	public ResponseEntity<ProductsEntity> editProduct(@RequestBody Product product){
		try {
			productsAdapter.edit(product);
		}catch(Exception e) {
			logger.error("Erro ao cadastrar");
			throw e;
		}
		return ResponseEntity.status(200).build();
	}
	
	
	@DeleteMapping("/delete/{productId}")
	public ResponseEntity<ProductsEntity> deleteProduct(@PathVariable("productId") Long productId){
		try {
			productsAdapter.delete(productId);
		}catch(Exception e) {
			logger.error("Erro ao deletar");
			throw e;
		}
		return ResponseEntity.status(204).build();
	}

}
