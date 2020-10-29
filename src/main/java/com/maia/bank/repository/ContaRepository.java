package com.maia.bank.repository;

import org.springframework.stereotype.Repository;

import com.maia.bank.domain.Conta;
import com.maia.bank.repository.generic.GenericRepository;

@Repository
public interface ContaRepository extends GenericRepository<Conta, Long> {

}
