package com.br.fiap.tech_challenge_lanchonete.application.core.services;

import java.util.List;
import java.util.Map;

import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Order;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Product;
import com.br.fiap.tech_challenge_lanchonete.application.ports.in.ListAllOrdersUseCase;
import com.br.fiap.tech_challenge_lanchonete.application.ports.in.MakeOrderUseCase;
import com.br.fiap.tech_challenge_lanchonete.application.ports.out.OrderPort;

public class OrderService implements MakeOrderUseCase, ListAllOrdersUseCase {

	private OrderPort orderPort;
	
	public OrderService(OrderPort orderPort) {
		this.orderPort = orderPort;
	}

	@Override
	public Order makeOrder(Long idCustomer, Map<Product, Integer> products) {
		Order order = orderPort.saveOrder(idCustomer, products);
		return order;
	}

	@Override
	public List<Order> getOrders() {
		return orderPort.getOrders();
	}
}
