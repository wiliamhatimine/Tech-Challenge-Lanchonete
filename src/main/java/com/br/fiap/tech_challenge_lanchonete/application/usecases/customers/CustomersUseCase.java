package com.br.fiap.tech_challenge_lanchonete.application.usecases.customers;

import java.util.List;

import com.br.fiap.tech_challenge_lanchonete.domain.Customer;

public interface CustomersUseCase {
	Customer saveCustomer(Customer customer);
	List<Customer> getAllCustomers();
}
