package com.maia.bank.services.impl;

import org.springframework.stereotype.Service;

import com.maia.bank.domain.Cliente;
import com.maia.bank.repository.ClienteRepository;
import com.maia.bank.repository.generic.CrudGeneric;
import com.maia.bank.services.ClienteServices;

@Service
public class ClienteServicesImpl extends CrudGeneric<Cliente,Long> implements ClienteServices{
	private static final long serialVersionUID = 1L;
	

	public ClienteServicesImpl(ClienteRepository repo) {
		super(repo);
		
	}
	
	

}
