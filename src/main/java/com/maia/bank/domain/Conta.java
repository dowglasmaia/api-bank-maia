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

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

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

	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	private Double saldo;

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

	public void setAddSaldo(Double valor) {
		if (this.saldo != null) {
			this.saldo += valor;
		} else {
			this.saldo = valor;
		}
	}

	public void setRetirarSaldo(Double valor) {
		if (this.saldo != null && this.saldo > 0.0 && this.saldo > valor) {			
			this.saldo -= valor;
		} else {
			new RuntimeException("Você não possuir saldo disponivel em Conta para realizar esta operação.");
		}
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getSaldo() {
		return saldo;
	}

	@Override
	public String toString() {
		return "Conta [id=" + id + ", numero=" + numero + ", banco=" + banco + ", cliente=" + cliente + ", saldo="
				+ saldo + "]";
	}
	
}
