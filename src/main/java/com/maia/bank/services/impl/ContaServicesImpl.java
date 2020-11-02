package com.maia.bank.services.impl;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maia.bank.domain.Banco;
import com.maia.bank.domain.Cliente;
import com.maia.bank.domain.Conta;
import com.maia.bank.domain.dtos.NewSaqueContaDTO;
import com.maia.bank.generic.CrudGeneric;
import com.maia.bank.repository.BancoRepository;
import com.maia.bank.repository.ContaRepository;
import com.maia.bank.services.ClienteServices;
import com.maia.bank.services.ContaServices;
import com.maia.bank.services.exceptions.BalanceExecption;
import com.maia.bank.services.exceptions.ObjectNotFoundExecption;
import com.maia.bank.services.exceptions.ValidationOperationExecption;

@Service
public class ContaServicesImpl extends CrudGeneric<Conta, Long> implements ContaServices {
	private static final long serialVersionUID = 1L;

	private ContaRepository repository;

	private static Logger log = LoggerFactory.getLogger(ContaServicesImpl.class);
	
	@Autowired
	private BancoRepository bancoRepository;

	@Autowired
	private ClienteServices clienteServices;
	
	public ContaServicesImpl(ContaRepository repo) {
		super(repo);
		this.repository = repo;		
	}
	
	
	@Override
	public Conta findByNumero(Long numConta) {
		return repository.findAllByNumero(numConta)
				.orElseThrow(() -> new ObjectNotFoundExecption("Conta não encontrada para o Numero: " + numConta));
	}

	@Override
	public Conta save(Cliente cliente) {
		Random random = new Random();
		long num = random.nextInt(99999);

		Banco banco = bancoRepository.findById(1l).get(); /* sera romovido depois */

		Conta conta = Conta.getInstance();
		conta.setId(null);
		conta.setBanco(banco);
		conta.setCliente(cliente);
		conta.setNumero(num);

		repository.save(conta);

		return conta;

	}

	@Override
	public Conta realizarSaque(NewSaqueContaDTO data) {

		Conta conta = findByNumero(data.getNumConta());
		Cliente cliente = clienteServices.findByParamName(data.getCpfCliente()); // validar com usario logado --- REFATORAR

		validaOpracaoSaque(cliente, conta, data.getValorSaque());
		log.info("conta " + conta.getNumero() + " passou na validação para realizar o saque.");

		conta.setRetirarSaldo(data.getValorSaque());
		conta = save(conta);

		return conta;
	}

	private void validaOpracaoSaque(Cliente cliente, Conta conta, Double valorSaque) {

		if (!conta.getCliente().equals(cliente)) {
			Random random = new Random();
			long protocoloOpraração = random.nextInt(9999);

			log.error("Conta " + conta.getNumero() + " não pertence ao Clietne: " + cliente.getNome()
					+ ". Operação cancelada!");
			throw new ValidationOperationExecption(
					"Operação cancelado. Entre em contato com o suporte para validar esta operação e informe o protocolo: "
							+ protocoloOpraração);
		}

		log.info("Validando os Valores");
		if (conta.getSaldo() < valorSaque) {
			log.error("O valor de saque " + valorSaque + " é maior que o Saldo " + conta.getSaldo());
			throw new BalanceExecption("Você não possuir saldo disponivel em Conta para realizar esta operação.");
		}

	}

}
