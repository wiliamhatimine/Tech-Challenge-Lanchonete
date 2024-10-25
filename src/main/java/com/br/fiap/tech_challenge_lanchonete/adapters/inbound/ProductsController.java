package com.br.fiap.tech_challenge_lanchonete.adapters.inbound;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.fiap.tech_challenge_lanchonete.adapters.outbound.ProductsAdapter;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Product;

@RestController
@RequestMapping("/products/api/v1")
public class ProductsController {
	
	@Autowired
	private ProductsAdapter productsAdapter;
	
	Logger logger = LoggerFactory.getLogger(ProductsController.class);
	
	@GetMapping("/get-by-categorie/{categorie}")
	public ResponseEntity<List<Product>> getByCategorie(@PathVariable("categorie") String categorie){
		List<Product> listProducts = productsAdapter.productByCategorie(categorie.toUpperCase());
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(listProducts);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		Product productDetail = new Product();
		try {
			productDetail = productsAdapter.save(product);
		}catch(Exception e) {
			logger.error("Erro ao cadastrar");
			throw e;
		}
		return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(productDetail);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Product> editProduct(@RequestBody Product product){
		Product productResponse = new Product();
		try {
			productResponse = productsAdapter.edit(product);
		}catch(Exception e) {
			logger.error("Erro ao cadastrar");
			throw e;
		}
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(productResponse);
	}
	
	
	@DeleteMapping("/delete/{productId}")
	public ResponseEntity<Product> deleteProduct(@PathVariable("productId") Long productId){
		try {
			productsAdapter.delete(productId);
		}catch(Exception e) {
			logger.error("Erro ao deletar");
			throw e;
		}
		return ResponseEntity.status(204).build();
	}

}
