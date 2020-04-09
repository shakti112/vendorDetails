package com.auro.vendor.exception.hander;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.auro.vendor.custom.exception.BusinessException;
import com.auro.vendor.custom.exception.UnAuthorizedUserException;
import com.auro.vendor.exception.model.ExceptionDetails;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ UnAuthorizedUserException.class, BusinessException.class })
	public final ResponseEntity<ExceptionDetails> handleDataExceptions(RuntimeException ex, WebRequest request) {
		ExceptionDetails exceptionDetails = new ExceptionDetails(ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY,
				request.getDescription(false));
		// log.error(ex.toString());
		// log.error(ExceptionUtils.getStackTrace(ex));
		return new ResponseEntity<ExceptionDetails>(exceptionDetails, HttpStatus.UNPROCESSABLE_ENTITY);
	}
}
