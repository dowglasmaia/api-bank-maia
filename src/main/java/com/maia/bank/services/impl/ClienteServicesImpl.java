package com.maia.bank.services.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.maia.bank.domain.Cliente;
import com.maia.bank.repository.CrudGeneric;
import com.maia.bank.services.ClienteServices;

@Service
public class ClienteServicesImpl extends CrudGeneric<Cliente,Long> implements ClienteServices{
	private static final long serialVersionUID = 1L;

	public ClienteServicesImpl(JpaRepository<Cliente, Long> repo) {
		super(repo);
		
	}
	

}
