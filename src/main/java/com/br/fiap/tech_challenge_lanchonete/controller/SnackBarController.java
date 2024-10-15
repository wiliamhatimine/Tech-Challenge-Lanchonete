package com.br.fiap.tech_challenge_lanchonete.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.fiap.tech_challenge_lanchonete.db.entity.CustomersEntity;
import com.br.fiap.tech_challenge_lanchonete.db.repository.CustomersRepository;

@RestController
@RequestMapping("/api/v1")
public class SnackBarController {

	@Autowired
	CustomersRepository repository;
	
	Logger logger = LoggerFactory.getLogger(SnackBarController.class)
;	
	@PostMapping("/customer")
	public ResponseEntity<CustomersEntity> insertCustomer(@RequestBody CustomersEntity customer){
		try {
			repository.save(new CustomersEntity(customer.getName(), customer.getEmail()));
		}catch(Exception e){
			logger.error("Ocorreu um erro ao cadastrar");
			throw e;
		}
		return ResponseEntity.ok("Cliente cadastrado com sucesso").status(201).build();
	}
	
	@GetMapping("/customer/{name}")
	public ResponseEntity<CustomersEntity> findByName(@PathVariable("name") String name){
		 Optional<CustomersEntity> customer = Optional.ofNullable(repository.findByName(name));
		 if(customer.isPresent()) {
			 return new ResponseEntity<>(customer.get(), HttpStatus.OK);
		 }else {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
	}
}
