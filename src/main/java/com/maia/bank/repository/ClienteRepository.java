package com.maia.bank.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.maia.bank.domain.Cliente;
import com.maia.bank.repository.generic.GenericRepository;

@Repository
public interface ClienteRepository extends GenericRepository<Cliente, Long> {

	Optional<Cliente> findByCpf(String cpf);

}
