package com.br.fiap.tech_challenge_lanchonete.adapters.inbound;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.fiap.tech_challenge_lanchonete.adapters.outbound.CustomersAdapter;
import com.br.fiap.tech_challenge_lanchonete.adapters.outbound.entity.CustomersEntity;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Customer;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Cliente", description = "Cadastro de clientes")
@RestController
@RequestMapping("/customers/api/v1")
public class CustomersController {

	@Autowired
	private CustomersAdapter customersAdapter;
	
	Logger logger = LoggerFactory.getLogger(CustomersController.class);
	
	@PostMapping("/create")
	@ApiResponse(responseCode = "201", description = "Cliente cadastrado com sucesso", content = { @Content(mediaType = "application/json",
	          schema = @Schema(implementation = Customer.class)) })
	@Operation(summary = "Cadastro de clientes")
	public ResponseEntity<Customer> insertCustomer(@RequestBody Customer customer){
		try {
			customersAdapter.save(customer);
		}catch(Exception e){
			logger.error("Ocorreu um erro ao cadastrar");
			throw e;
		}
		return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(customer);
	}
}
