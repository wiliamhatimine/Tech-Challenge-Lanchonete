package com.br.fiap.tech_challenge_lanchonete.domain.enums;

public enum CategorieEnums {
	LANCHE("LANCHE"),
	ACOMPANHAMENTO("ACOMPANHAMENTO"),
	BEBIDA("BEBIDA"),
	SOBREMESA("SOBREMESA");
	
	private String text;

	CategorieEnums(String text) {
		this.text = text;
	}

	public String getText() {
		return this.text;
	}

	public static CategorieEnums fromString(String text) {
		for (CategorieEnums b : CategorieEnums.values()) {
			if (b.text.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}
}
