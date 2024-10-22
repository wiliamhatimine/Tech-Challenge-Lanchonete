package com.br.fiap.tech_challenge_lanchonete.application.ports.out;

import java.util.List;
import java.util.Map;

import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Order;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Product;

public interface OrderPort {

	Order saveOrder(Long idCustomer,Map<Product, Integer> products);
	Order getOrder(String idOrder);
	List<Order> getOrders();
}
