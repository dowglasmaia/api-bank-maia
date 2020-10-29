package com.maia.bank.services.impl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maia.bank.domain.Banco;
import com.maia.bank.domain.Cliente;
import com.maia.bank.domain.Conta;
import com.maia.bank.generic.CrudGeneric;
import com.maia.bank.repository.BancoRepository;
import com.maia.bank.repository.ContaRepository;
import com.maia.bank.services.ContaServices;

@Service
public class ContaServicesImpl extends CrudGeneric<Conta, Long> implements ContaServices {
	private static final long serialVersionUID = 1L;

	@Autowired
	private BancoRepository bancoRepository;

	@Autowired
	private ContaRepository repository;

	public ContaServicesImpl(ContaRepository repo) {
		super(repo);

	}

	@Override
	public Conta save(Cliente cliente) {

		Random random = new Random();
		long num = random.nextInt(99999);

		Banco banco = bancoRepository.findById(1l).get(); /*sera romovido depois*/

		Conta conta = Conta.getInstance();
			conta.setId(null);
			conta.setBanco(banco);
			conta.setCliente(cliente);
			conta.setNumero(num);
			
		repository.save(conta);
			
		return conta;

	}

}
