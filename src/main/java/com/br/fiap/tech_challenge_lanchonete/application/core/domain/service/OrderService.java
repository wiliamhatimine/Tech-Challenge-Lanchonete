package com.br.fiap.tech_challenge_lanchonete.application.core.domain.service;

import java.util.List;

import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Order;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.ProductOrder;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Queue;
import com.br.fiap.tech_challenge_lanchonete.application.ports.in.ClientMakeOrderUseCase;
import com.br.fiap.tech_challenge_lanchonete.application.ports.in.ListAllOrdersUseCase;
import com.br.fiap.tech_challenge_lanchonete.application.ports.in.MakeOrderUseCase;
import com.br.fiap.tech_challenge_lanchonete.application.ports.out.OrderPort;
import com.br.fiap.tech_challenge_lanchonete.application.ports.out.QueuePort;

public class OrderService implements ClientMakeOrderUseCase, ListAllOrdersUseCase, MakeOrderUseCase{

	private OrderPort orderPort;
	private QueuePort queuePort;
	
	@Override
	public Order saveOrder(Long idCustomer, List<ProductOrder> products) {
		return orderPort.saveOrder(idCustomer, products);
	}

	@Override
	public List<Order> getOrders() {
		return orderPort.getOrders();
	}

	@Override
	public Queue checkOrderStatus(Long idOrder) {
		return queuePort.checkOrderStatus(idOrder);
	}

}
