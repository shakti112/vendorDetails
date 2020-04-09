package com.auro.vendor.exception.model;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionDetails {

	private String errorMessage;

	private HttpStatus httpStatus;

	private String errorDetails;

	public ExceptionDetails(String errorMessage, HttpStatus httpStatus, String errorDetails) {
		super();
		this.errorMessage = errorMessage;
		this.httpStatus = httpStatus;
		this.errorDetails = errorDetails;
	}

	public ExceptionDetails() {

	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}

}
