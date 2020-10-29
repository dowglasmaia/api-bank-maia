package com.maia.bank.services.impl;

import org.springframework.stereotype.Service;

import com.maia.bank.domain.Conta;
import com.maia.bank.generic.CrudGeneric;
import com.maia.bank.repository.ContaRepository;
import com.maia.bank.services.ContaServices;

@Service
public class ContaServicesImpl extends CrudGeneric<Conta, Long> implements ContaServices {
	private static final long serialVersionUID = 1L;

	public ContaServicesImpl(ContaRepository repo) {
		super(repo);

	}

}
