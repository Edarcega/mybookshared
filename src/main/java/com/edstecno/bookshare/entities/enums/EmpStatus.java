package com.edstecno.bookshare.entities.enums;

public enum EmpStatus {	
	EM_DIA(1), 
	EM_ATRASO(2),
	CANCELADO(3),
	DEVOLVIDO(4);
	
	private int code;
	
	// o construtor do tipo enumerado e um caso especial, ele pe rivate
	private EmpStatus (int code) {
		this.code =code;
	}
	
	// este metodo permite o acesso do codigo
	public int getCode() {
		return code;
	}
	
	public static EmpStatus valueOf(int conde) {
		for (EmpStatus value : EmpStatus.values()) {
			if (value.getCode() == conde){
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid Order Status code");
	}
	
}
