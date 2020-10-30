package com.maia.bank.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maia.bank.domain.Conta;
import com.maia.bank.domain.dtos.NewSaqueContaDTO;
import com.maia.bank.services.ContaServices;

@RestController
@RequestMapping("/api/contas")
public class ContaController {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ContaServices contaServices;

	@GetMapping
	public ResponseEntity<List<Conta>> obterTodosAsContas() {
		List<Conta> lista = contaServices.findAll();
		return ResponseEntity.ok().body(lista);
	}

	@PostMapping("/saque")
	public ResponseEntity<Conta> realizarSaque(@RequestBody NewSaqueContaDTO data) {

		Conta conta = contaServices.realizarSaque(data);

		return ResponseEntity.ok().body(conta);
	}

}
