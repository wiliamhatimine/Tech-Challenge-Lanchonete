package com.br.fiap.tech_challenge_lanchonete.adapters.inbound;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.fiap.tech_challenge_lanchonete.adapters.outbound.CustomersAdapter;
import com.br.fiap.tech_challenge_lanchonete.adapters.outbound.entity.CustomersEntity;

@RestController
@RequestMapping("/customers/api/v1")
public class CustomersController {

	@Autowired
	private CustomersAdapter customersAdapter;
	
	Logger logger = LoggerFactory.getLogger(CustomersController.class);
	
	@PostMapping("/cadastrar")
	public ResponseEntity<CustomersEntity> insertCustomer(@RequestBody CustomersEntity customer){
		try {
			customersAdapter.save(customer.getName(), customer.getEmail());
		}catch(Exception e){
			logger.error("Ocorreu um erro ao cadastrar");
			throw e;
		}
		return ResponseEntity.status(201).build();
	}
}
