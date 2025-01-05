package com.br.fiap.tech_challenge_lanchonete.infra.services.customers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.br.fiap.tech_challenge_lanchonete.domain.Customer;
import com.br.fiap.tech_challenge_lanchonete.gateway.CustomersRepositoryGateway;
import com.br.fiap.tech_challenge_lanchonete.infra.persistence.entities.CustomersEntity;
import com.br.fiap.tech_challenge_lanchonete.infra.persistence.repositories.CustomersRepository;

@Component
public class CustomersService implements CustomersRepositoryGateway {

	private CustomersRepository customersRepository;

	public CustomersService(CustomersRepository customersRepository) {
		this.customersRepository = customersRepository;
	}

	@Override
	public Customer save(Customer customer) {
		CustomersEntity customersEntity = new CustomersEntity(customer.getName(), customer.getEmail(),
				customer.getCpf());
		customer.setIdCustomer(customersRepository.save(customersEntity).getIdCustomer());
		return customer;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customersRepository.findAll().stream().map(customer -> {
			return customer.toModel(customer.getIdCustomer());
		}).toList();
	}

}
