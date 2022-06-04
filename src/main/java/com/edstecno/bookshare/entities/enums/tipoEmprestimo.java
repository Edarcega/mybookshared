package com.edstecno.bookshare.entities.enums;

public enum tipoEmprestimo {
	
	COMUM(1),
	ESPECIAL(2);
	
	private int code;
	
	private tipoEmprestimo(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static EmpStatus valueOf(int code) {
		for (EmpStatus x : EmpStatus.values()) {
			if(x.getCode() == code) {
				return x;
			}
		}
		throw new IllegalArgumentException("Invalid Emprestimo Status code");
	}

}
