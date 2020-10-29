package com.maia.bank.services;

import org.springframework.stereotype.Service;

import com.maia.bank.domain.Cliente;
import com.maia.bank.generic.CrudServices;

@Service
public interface ClienteServices extends CrudServices<Cliente, Long>{

	

}
