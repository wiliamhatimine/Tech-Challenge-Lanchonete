package com.br.fiap.tech_challenge_lanchonete.application.core.service;

import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Customer;
import com.br.fiap.tech_challenge_lanchonete.application.ports.in.LoginUseCase;
import com.br.fiap.tech_challenge_lanchonete.application.ports.out.CustomersPort;

public class CustomerService implements LoginUseCase{

	private CustomersPort customersPort;
	
	@Override
	public Customer saveCustomer(Customer customer) {
		return customersPort.save(customer);
	}

}
