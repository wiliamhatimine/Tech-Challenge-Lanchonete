package com.br.fiap.tech_challenge_lanchonete.application.ports.in;

import java.util.List;

import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Order;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.ProductOrder;

public interface MakeOrderUseCase {

	Order makeOrder(Long idCustomer, List<ProductOrder> products);
}
