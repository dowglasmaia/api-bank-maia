package com.maia.bank.utils;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Service;

import com.maia.bank.domain.Banco;
import com.maia.bank.domain.Cliente;
import com.maia.bank.domain.Conta;
import com.maia.bank.repository.BancoRepository;
import com.maia.bank.services.ClienteServices;
import com.maia.bank.services.ContaServices;

@Service
public class TestsIntegrationsDB {

	@Autowired
	private ClienteServices clienteServices;
	
	@Autowired
	private ContaServices contaServices;
	
	@Autowired
	private BancoRepository bancoRepo;

	public void instanciateTestDatabase() throws ParseException {
		
		Banco bc1 = Banco.builder()
				.nome("Maya Bank")
				.numero(00202)
				.build();
		bancoRepo.save(bc1);
		
		Cliente cl1 = Cliente.builder()
				.nome("Dowglas Maia")
				.cpf("66472775877")
				.email("dowglasmaia@live.com")
				.nomeDaMae("Maria M")
				.ddd("41")
				.celular("991366187")
				.build();
		
		
		clienteServices.save(cl1);
		
		Conta ct1 = Conta.getInstance();
		Random random = new Random();
		long num =  random.nextInt(99999) * 10 ;			
		
		ct1.setBanco(bc1);
		ct1.setCliente(cl1);
		ct1.setNumero(000+num);
		ct1.setAddSaldo(500.0);
		
		contaServices.save(ct1);
		
		

	}

}
