package com.maia.bank.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Service;

import com.maia.bank.domain.Cliente;
import com.maia.bank.services.ClienteServices;

@Service
public class TestsIntegrationsDB {

	@Autowired
	private ClienteServices clienteServices;

	public void instanciateTestDatabase() throws ParseException {
		
		Cliente c1 = Cliente.builder()
				.nome("Dowglas Maia")
				.cpf("66472775877")
				.email("dowglasmaia@live.com")
				.nomeDaMae("Maria M")
				.ddd("41")
				.celular("991366187")
				.build();
		
		
		clienteServices.save(c1);

	}

}
