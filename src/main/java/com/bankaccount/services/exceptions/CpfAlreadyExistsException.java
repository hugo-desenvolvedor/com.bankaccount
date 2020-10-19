package com.bankaccount.services.exceptions;

public class CpfAlreadyExistsException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2106676231151454274L;

	public CpfAlreadyExistsException() {
		super();
	}
	
	public CpfAlreadyExistsException(String mensagem) {
		super(mensagem);
	}

	public CpfAlreadyExistsException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
