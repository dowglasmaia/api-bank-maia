package com.maia.bank.services.exceptions;

public class BalanceExecption extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public BalanceExecption() {
		super();
	}

	public BalanceExecption(String msg) {
		super(msg);
	}

}
