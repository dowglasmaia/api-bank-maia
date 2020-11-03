package com.maia.bank.domain.dtos;

import com.maia.bank.domain.Cliente;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteDTO {

	private Long id;
	private String nome;
	private String nomeDaMae;
	private String cpf;
	private String email;
	private String ddd;
	private String celular;

	public ClienteDTO(Cliente obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.nomeDaMae = obj.getNomeDaMae();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.ddd = obj.getDdd();
		this.celular = obj.getCelular();
	}

}
