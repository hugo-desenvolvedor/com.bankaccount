package com.bankaccount.handlers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bankaccount.services.exceptions.ClientNotFoundException;
import com.bankaccount.services.exceptions.ErrorExceptionDetails;

@ControllerAdvice
public class ResourceExceptionHandler {
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ErrorExceptionDetails> handleDataIntegrityViolationException(
			DataIntegrityViolationException e, HttpServletRequest request) {
		ErrorExceptionDetails error = new ErrorExceptionDetails();

		error.setStatus(400l);
		error.setTitle("Data integrity violation: the json is invalid");
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ErrorExceptionDetails> handleHttpMessageNotReadableException(
			HttpMessageNotReadableException e, HttpServletRequest request) {
		ErrorExceptionDetails error = new ErrorExceptionDetails();

		error.setStatus(400l);
		error.setTitle("Http Message Not Readable: the format is invalid");
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler(ClientNotFoundException.class)
	public ResponseEntity<ErrorExceptionDetails> handleClientNotFoundException(ClientNotFoundException e,
			HttpServletRequest request) {
		ErrorExceptionDetails error = new ErrorExceptionDetails();

		error.setStatus(404l);
		error.setTitle("Client not found");
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

}
