package com.br.fiap.tech_challenge_lanchonete.gateway;

import java.util.List;

import com.br.fiap.tech_challenge_lanchonete.domain.Customer;

public interface CustomersRepositoryGateway {

	Customer save(Customer customer);
	List<Customer> getAllCustomers();
}
