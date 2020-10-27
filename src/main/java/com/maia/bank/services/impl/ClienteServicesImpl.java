package com.maia.bank.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maia.bank.domain.Cliente;
import com.maia.bank.repository.ClienteRepository;
import com.maia.bank.services.ClienteServices;

@Service
public class ClienteServicesImpl implements ClienteServices {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ClienteRepository repo;

	@Override
	public Cliente save(Cliente entity) {
		entity.setId(null);
		Cliente cliente = repo.save(entity);
		return cliente;
	}

	@Override
	public Cliente Update(Cliente entity) {
		Cliente cliente = repo.save(entity);
		return cliente;
	}

	@Override
	public Cliente findById(Long id) {
		return repo.findById(id).orElseThrow(
				() -> new RuntimeException("Cliente Não encontrado para o ID: " + id));
	}

	@Override
	public Cliente findByParamName(String cpf) {		
		return repo.findByCpf(cpf).get();
	}

	@Override
	public List<Cliente> findAll() {		
		return repo.findAll();
	}

}
