package com.maia.bank.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;


public interface CrudServices<T> extends Serializable {

	@Transactional
	T save(T entity);

	@Transactional
	T Update(T entity);

	@Transactional(readOnly = true)
	T findById(Long id);

	@Transactional(readOnly = true)
	T findByParamName(String paramName);

	@Transactional(readOnly = true)
	List<T> findAll();

}
