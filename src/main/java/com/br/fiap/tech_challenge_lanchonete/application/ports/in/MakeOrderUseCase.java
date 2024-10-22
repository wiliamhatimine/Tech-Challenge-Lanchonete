package com.br.fiap.tech_challenge_lanchonete.application.ports.in;

import java.util.Map;

import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Order;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Product;

public interface MakeOrderUseCase {

	Order makeOrder(Long idCustomer, Map<Product, Integer> products);
}
