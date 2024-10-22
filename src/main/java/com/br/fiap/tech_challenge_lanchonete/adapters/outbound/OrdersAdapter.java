package com.br.fiap.tech_challenge_lanchonete.adapters.outbound;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.br.fiap.tech_challenge_lanchonete.adapters.outbound.entity.OrderEntity;
import com.br.fiap.tech_challenge_lanchonete.adapters.outbound.repository.OrderRepository;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Order;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Product;
import com.br.fiap.tech_challenge_lanchonete.application.ports.out.OrderPort;

@Component
public class OrdersAdapter implements OrderPort {

	private OrderRepository orderRepository;
	
	public OrdersAdapter(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Override
	public Order getOrder(String idOrder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order saveOrder(Long idCustomer, Map<Product, Integer> products) {
		Long customer = Objects.nonNull(idCustomer) ? idCustomer : null;
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setCustomer(customer);
		orderEntity.setProduct(products);
		return orderRepository.save(orderEntity).getOrder(products);
	}

	@Override
	public List<Order> getOrders() {
		return orderRepository.findAll().stream().map(order ->{
			return order.getOrder(order.getProducts());
		}).toList();
	}
}
