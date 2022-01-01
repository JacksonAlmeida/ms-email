package com.sunflower.msemail.enums;

public enum StatusEmail {

	Send(1), Error(2);

	private Integer code;

	private StatusEmail(int code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public static StatusEmail valueOf(int code) {
		for (StatusEmail value : StatusEmail.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código inválido");
	}
}
