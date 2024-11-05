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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Produtos", description = "Gerenciamento de produtos")
@RestController
@RequestMapping("/products/api/v1")
public class ProductsController {
	
	@Autowired
	private ProductsAdapter productsAdapter;
	
	Logger logger = LoggerFactory.getLogger(ProductsController.class);
	
	@GetMapping("/get-by-categorie/{categorie}")
	@Operation(summary = "Obter produtos por categoria")
	@ApiResponse(responseCode = "200", description = "Lista de produtos obtido com sucesso", content = { @Content(mediaType = "application/json",
			array = @ArraySchema( schema = @Schema(implementation = Product.class)))})
	public ResponseEntity<List<Product>> getByCategorie(@PathVariable("categorie") String categorie){
		List<Product> listProducts = productsAdapter.productByCategorie(categorie.toUpperCase());
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(listProducts);
	}
	
	@PostMapping("/create")
	@Operation(summary = "Cadastro de produto")
	@ApiResponse(responseCode = "200", description = "Produto cadastrado com sucesso", content = { @Content(mediaType = "application/json",
	 schema = @Schema(implementation = Product.class)) })
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
	@ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso", content = { @Content(mediaType = "application/json",
	 schema = @Schema(implementation = Product.class)) })
	@Operation(summary = "Atualizar dados de produto")
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
	@ApiResponse(responseCode = "200", description = "Produto deletado com sucesso", content = { @Content(mediaType = "application/json",
	 schema = @Schema(implementation = Product.class)) })
	@Operation(summary = "Deletar produto")
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
