package com.br.fiap.tech_challenge_lanchonete.application.core.domain.enums;

public enum PaymentStatusEnums {
	PAGO("PAGO"),
	AGUARDANDO_PAGAMENTO("AGUARDANDO_PAGAMENTO"),
	ERRO("ERRO");
	
	private String text;

	PaymentStatusEnums(String text) {
		this.text = text;
	}

	public String getText() {
		return this.text;
	}

	public static PaymentStatusEnums fromString(String text) {
		for (PaymentStatusEnums b : PaymentStatusEnums.values()) {
			if (b.text.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}

}
