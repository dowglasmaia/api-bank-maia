package com.maia.bank.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maia.bank.domain.Cliente;
import com.maia.bank.domain.dtos.NewClienteDTO;
import com.maia.bank.repository.ClienteRepository;
import com.maia.bank.services.ClienteServices;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClienteServicesImpl implements ClienteServices {
	private static final long serialVersionUID = 1L;

	
	private ClienteRepository repo;

	public ClienteServicesImpl(ClienteRepository repository) {
		this.repo = repository;
	}
	
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

	@Override
	public Cliente fromDTO(NewClienteDTO dto) {
		Cliente entity = Cliente.builder()
				.nome(dto.getNome())
				.cpf(dto.getCpf())
				.email(dto.getEmail())
				.nomeDaMae(dto.getNomeDaMae())
				.ddd(dto.getDdd())
				.celular(dto.getCelular())
				.build();
				
		return entity;
	}

}
