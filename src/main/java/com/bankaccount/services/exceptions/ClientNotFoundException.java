package com.bankaccount.services.exceptions;

public class ClientNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2106676231151454274L;

	public ClientNotFoundException() {
		super();
	}
	
	public ClientNotFoundException(String mensagem) {
		super(mensagem);
	}

	public ClientNotFoundException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
