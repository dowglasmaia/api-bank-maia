package com.maia.bank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maia.bank.domain.Banco;

@Repository
public interface BancoRepository extends JpaRepository<Banco, Long> {

	Optional<Banco> findByNumero(Integer numero);

}
