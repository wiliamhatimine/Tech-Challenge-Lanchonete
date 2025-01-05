package com.br.fiap.tech_challenge_lanchonete.application.usecases.orders;

import java.util.List;

import com.br.fiap.tech_challenge_lanchonete.domain.Order;
import com.br.fiap.tech_challenge_lanchonete.domain.ProductOrder;
import com.br.fiap.tech_challenge_lanchonete.gateway.OrderRepositoryGateway;

public class OrderUseCase {
	
	private final OrderRepositoryGateway orderRepositoryGateway;
	
	public OrderUseCase(OrderRepositoryGateway orderRepositoryGateway) {
		this.orderRepositoryGateway = orderRepositoryGateway;
	}

	public Order saveOrder(Long idCustomer, List<ProductOrder> products) {
		return orderRepositoryGateway.saveOrder(idCustomer, products);
	};
	
	public List<Order> getOrders(){
		return orderRepositoryGateway.getOrders();
	}
}
