package com.maia.bank.config.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.maia.bank.repository.ClienteRepository;

public class UnicoCPFValidator implements ConstraintValidator<UnicoCPF, String>{

	@Autowired
	private ClienteRepository repo;
	
	/*retona o cliente caso o cpf do mesmo não esteja presente na base de dados*/
	@Override
	public boolean isValid(String cpf, ConstraintValidatorContext context) {
		return !repo.findByCpf(cpf).isPresent();
	}
	
	

}
