package com.br.fiap.tech_challenge_lanchonete.application.ports.out;

import java.util.List;

import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Customer;

public interface CustomersPort {

	Customer save(Customer customer);
	List<Customer> getAllCustomers();
}
