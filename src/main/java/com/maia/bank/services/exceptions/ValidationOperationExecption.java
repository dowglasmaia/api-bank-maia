package com.maia.bank.services.exceptions;

public class ValidationOperationExecption extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ValidationOperationExecption() {
		super();
	}

	public ValidationOperationExecption(String msg) {
		super(msg);
	}

}
