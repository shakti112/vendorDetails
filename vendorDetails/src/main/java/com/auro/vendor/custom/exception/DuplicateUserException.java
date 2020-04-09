package com.auro.vendor.custom.exception;

import com.auro.vendor.Utils.Messages;

public class DuplicateUserException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DuplicateUserException(String exception) {
		super(exception);
	}

	public DuplicateUserException() {
		super(Messages.ExceptionMessages.UNAUTHORIZED_USER);
	}
}
