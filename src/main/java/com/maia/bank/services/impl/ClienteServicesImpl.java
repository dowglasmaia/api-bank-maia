package com.maia.bank.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maia.bank.domain.Cliente;
import com.maia.bank.generic.CrudGeneric;
import com.maia.bank.repository.ClienteRepository;
import com.maia.bank.services.ClienteServices;
import com.maia.bank.services.exceptions.ObjectNotFoundExecption;

@Service
public class ClienteServicesImpl extends CrudGeneric<Cliente,Long> implements ClienteServices{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ClienteRepository repository;
	
	public ClienteServicesImpl(ClienteRepository repo) {
		super(repo);			
	}
	
	@Override
	public Cliente findByParamName(String cpf) {
		return repository.findByCpf(cpf).orElseThrow( 
				()-> new ObjectNotFoundExecption("Nenhum Cliente localizado para o CPF: " +cpf) );
	}	


}
