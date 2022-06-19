package com.edstecno.bookshare.entities.enums;

public enum TipoEmprestimo {

	COMUM(1), ESPECIAL(2);

	private int code;

	private TipoEmprestimo(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static TipoEmprestimo valueOf(int code) {
		for (TipoEmprestimo x : TipoEmprestimo.values()) {
			if (x.getCode() == code) {
				return x;
			}
		}
		throw new IllegalArgumentException("Invalid Emprestimo Status code");
	}

}
