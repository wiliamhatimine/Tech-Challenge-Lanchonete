package com.br.fiap.tech_challenge_lanchonete.domain.enums;

public enum QueueEnums {
	RECEBIDO("RECEBIDO"),
	EM_PREPARACAO("EM_PREPARACAO"),
	PRONTO("PRONTO"),
	FINALIZADO("FINALIZADO");
	
	private String text;

	QueueEnums(String text) {
		this.text = text;
	}

	public String getText() {
		return this.text;
	}

	public static QueueEnums fromString(String text) {
		for (QueueEnums b : QueueEnums.values()) {
			if (b.text.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}
}
