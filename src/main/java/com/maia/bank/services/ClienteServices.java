package com.maia.bank.services;

import org.springframework.stereotype.Service;

import com.maia.bank.domain.Cliente;
import com.maia.bank.domain.dtos.NewClienteDTO;

@Service
public interface ClienteServices extends CrudServices<Cliente>{

	Cliente fromDTO( NewClienteDTO dto);

}
