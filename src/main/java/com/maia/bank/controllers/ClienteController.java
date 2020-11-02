package com.maia.bank.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.maia.bank.domain.Cliente;
import com.maia.bank.domain.Conta;
import com.maia.bank.domain.dtos.ClienteDTO;
import com.maia.bank.domain.dtos.NewClienteDTO;
import com.maia.bank.services.ClienteServices;
import com.maia.bank.services.ContaServices;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ClienteServices clienteServices;
	
	@Autowired
	private ContaServices contaServices;

	@PostMapping
	public ResponseEntity<Void> createNewClienteAndAccount(@Valid @RequestBody NewClienteDTO dto) {
		
		Cliente entity = modelMapper.map(dto, Cliente.class);
			entity = clienteServices.save(entity);
		
			Conta conta = contaServices.save(entity);			
			
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(conta.getNumero()).toUri();				
		return ResponseEntity.created(uri).build();

	}

	@GetMapping
	public ResponseEntity<List<ClienteDTO>> obterTodosOsClietnes() {		
		List<ClienteDTO> list = clienteServices.findAll()
				.stream().map(obj -> new ClienteDTO(obj) ).collect(Collectors.toList());		
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/cpf/{cpf}")
	public ResponseEntity<Cliente> obterClietnePorCPF(@PathVariable String cpf) {
		Cliente result = clienteServices.findByParamName(cpf);
		return ResponseEntity.ok().body(result);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> obterClietnePorID(@PathVariable Long id) {
		Cliente result = clienteServices.findById(id);
		return ResponseEntity.ok().body(result);
	}
	
	

}
