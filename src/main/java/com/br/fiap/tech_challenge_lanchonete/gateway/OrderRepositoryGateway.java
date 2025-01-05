package com.br.fiap.tech_challenge_lanchonete.gateway;

import java.util.List;

import com.br.fiap.tech_challenge_lanchonete.domain.Order;
import com.br.fiap.tech_challenge_lanchonete.domain.ProductOrder;

public interface OrderRepositoryGateway {

	Order saveOrder(Long idCustomer,List<ProductOrder> products);
	List<Order> getOrders();
}
