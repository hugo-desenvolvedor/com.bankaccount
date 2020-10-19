package com.bankaccount.services.exceptions;

public class EmailAlreadyExistsException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2106676231151454274L;

	public EmailAlreadyExistsException() {
		super();
	}
	
	public EmailAlreadyExistsException(String mensagem) {
		super(mensagem);
	}

	public EmailAlreadyExistsException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
