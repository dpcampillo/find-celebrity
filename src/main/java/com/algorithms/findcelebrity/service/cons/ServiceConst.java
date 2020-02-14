package com.algorithms.findcelebrity.service.cons;

public enum ServiceConst {
	MESSAGE_NOT_FOUND("Celebrity not found"),
	WRONG_FORMAT_FILE("Wrong format file");

	private String message;

	private ServiceConst(String message) {
		this.message = message;
	}

	public String getValue() {
		return message;
	}
}
