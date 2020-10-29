package com.maia.bank.repository.generic;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * JPA Generico  }.
 *
 * @author Dowglas Maia
 */

@NoRepositoryBean
public interface GenericRepository<T,PK extends Serializable> extends JpaRepository<T, PK> {

	

}
