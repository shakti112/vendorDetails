package com.auro.vendor.custom.exception;

import com.auro.vendor.Utils.Messages;

public class UnAuthorizedUserException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnAuthorizedUserException(String exception) {
		super(exception);
	}

	public UnAuthorizedUserException() {
		super(Messages.ExceptionMessages.UNAUTHORIZED_USER);
	}

}
