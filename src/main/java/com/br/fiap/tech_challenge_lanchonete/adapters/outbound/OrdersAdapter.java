package com.br.fiap.tech_challenge_lanchonete.adapters.outbound;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.br.fiap.tech_challenge_lanchonete.adapters.outbound.entity.OrderEntity;
import com.br.fiap.tech_challenge_lanchonete.adapters.outbound.repository.OrderRepository;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Order;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.ProductOrder;
import com.br.fiap.tech_challenge_lanchonete.application.ports.out.OrderPort;

@Component
public class OrdersAdapter implements OrderPort {

	private Double total;
	
	private OrderRepository orderRepository;
	
	public OrdersAdapter(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Override
	public Order saveOrder(Long idCustomer, List<ProductOrder> products) {
		Long customer = Objects.nonNull(idCustomer) ? idCustomer : null;
		total = 0.0;
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setCustomer(customer);
		orderEntity.setProducts(products);
		products.forEach(product -> {
			int quantity = product.getQuantity();
			if(quantity > 1) {
				total = total + (product.getPrice()*quantity);
			}else {
				total = total + product.getPrice();
			}
		});
		orderEntity.setTotal(total);
		return orderRepository.save(orderEntity).getOrder(products, total);
	}

	@Override
	public List<Order> getOrders() {
		return orderRepository.findAll().stream().map(order ->{
			return order.toModel(order);
		}).toList();
	}
}
