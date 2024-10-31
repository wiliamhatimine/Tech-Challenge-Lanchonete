package com.br.fiap.tech_challenge_lanchonete.application.ports.in;

import java.util.List;

import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Customer;

public interface CustomersUseCase {
	Customer saveCustomer(Customer customer);
	List<Customer> getAllCustomers();
}
