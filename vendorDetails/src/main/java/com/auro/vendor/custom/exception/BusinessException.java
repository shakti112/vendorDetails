package com.auro.vendor.custom.exception;

public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public BusinessException(String exception) {
		super(exception);
	}

	// public BusinessException() {
	// super(Messages.ExceptionMessages.UNAUTHORIZED_USER);
	// }
}
