package com.br.fiap.tech_challenge_lanchonete.adapters.outbound;

import org.springframework.stereotype.Component;

import com.br.fiap.tech_challenge_lanchonete.adapters.outbound.entity.CustomersEntity;
import com.br.fiap.tech_challenge_lanchonete.adapters.outbound.repository.CustomersRepository;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Customer;
import com.br.fiap.tech_challenge_lanchonete.application.ports.out.CustomersPort;

@Component
public class CustomersAdapter implements CustomersPort{

	private CustomersRepository customersRepository;
	
	public CustomersAdapter(CustomersRepository customersRepository) {
		this.customersRepository = customersRepository;
	}

	@Override
	public Customer save(Customer customer) {
		CustomersEntity customersEntity = new CustomersEntity(customer.getName(), customer.getEmail(), customer.getCpf());
		customer.setIdCustomer(customersRepository.save(customersEntity).getIdCustomer());
		return customer;
	}

}
