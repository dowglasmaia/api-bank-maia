package com.maia.bank.domain;

import java.io.Serializable;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table
@Entity
public class Conta implements Serializable {
	private static final long serialVersionUID = 1L;

	private static Conta instance;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 50)
	private Long numero;

	@ManyToOne
	private Banco banco;

	@OneToOne
	private Cliente cliente;

	private Conta() {

	}

	/*** Singleton ***/
	public static Conta getInstance() {
		if (instance == null) {
			synchronized (Conta.class) {
				if (instance == null) {
					instance = new Conta();
				}
			}
		}
		return instance;
	}

}
