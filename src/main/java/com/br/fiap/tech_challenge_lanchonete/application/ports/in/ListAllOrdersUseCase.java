package com.br.fiap.tech_challenge_lanchonete.application.ports.in;

import java.util.List;

import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Order;

public interface ListAllOrdersUseCase {
	
	List<Order> getOrders();

}
