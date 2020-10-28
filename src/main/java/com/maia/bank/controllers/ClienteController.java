package com.maia.bank.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.maia.bank.domain.Cliente;
import com.maia.bank.domain.dtos.NewClienteDTO;
import com.maia.bank.services.ClienteServices;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ClienteServices clienteServices;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public ResponseEntity<Void> createNewCliente(@Valid @RequestBody NewClienteDTO dto) {
		Cliente entity = modelMapper.map(dto, Cliente.class);
		entity = clienteServices.save(entity);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	@GetMapping
	public ResponseEntity<List<Cliente>> obterTodosOsClietnes() {
		List<Cliente> list = clienteServices.findAll();
		return ResponseEntity.ok().body(list);
	}

}
