package com.maia.bank.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.maia.bank.domain.Banco;
import com.maia.bank.repository.generic.GenericRepository;

@Repository
public interface BancoRepository extends GenericRepository<Banco, Long> {

	Optional<Banco> findByNumero(Integer numero);

}
