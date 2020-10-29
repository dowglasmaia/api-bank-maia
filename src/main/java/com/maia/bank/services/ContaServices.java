package com.maia.bank.services;

import org.springframework.stereotype.Service;

import com.maia.bank.domain.Conta;
import com.maia.bank.generic.CrudServices;

@Service
public interface ContaServices extends CrudServices<Conta, Long>{

	

}
