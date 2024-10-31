package com.br.fiap.tech_challenge_lanchonete.application.core.service;

import java.util.List;

import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Customer;
import com.br.fiap.tech_challenge_lanchonete.application.ports.in.CustomersUseCase;
import com.br.fiap.tech_challenge_lanchonete.application.ports.out.CustomersPort;

public class CustomerService implements CustomersUseCase{

	private CustomersPort customersPort;
	
	@Override
	public Customer saveCustomer(Customer customer) {
		return customersPort.save(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customersPort.getAllCustomers();
	}

}
