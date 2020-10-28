package com.maia.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maia.bank.domain.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {



}
