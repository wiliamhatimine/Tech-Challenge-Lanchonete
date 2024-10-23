package com.br.fiap.tech_challenge_lanchonete.application.ports.out;

import java.util.List;

import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Order;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.ProductOrder;

public interface OrderPort {

	Order saveOrder(Long idCustomer,List<ProductOrder> products);
	List<Order> getOrders();
}
