package com.br.fiap.tech_challenge_lanchonete.infra.services.orders;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.br.fiap.tech_challenge_lanchonete.application.usecases.orders.OrderUseCase;
import com.br.fiap.tech_challenge_lanchonete.domain.Order;
import com.br.fiap.tech_challenge_lanchonete.domain.ProductOrder;
import com.br.fiap.tech_challenge_lanchonete.infra.persistence.entities.OrderEntity;

@Component
public class OrdersService {

	private final OrderUseCase orderUseCase;
	
	public OrdersService(OrderUseCase orderUseCase) {
		this.orderUseCase = orderUseCase;
	}

	public Order saveOrder(Long idCustomer, List<ProductOrder> products) {
		return orderUseCase.saveOrder(idCustomer, products);
	}

	public List<Order> getOrders() {
		return orderUseCase.getOrders();
	}
}
