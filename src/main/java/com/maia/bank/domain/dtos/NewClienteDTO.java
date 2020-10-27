package com.maia.bank.domain.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import com.maia.bank.config.utils.UnicoCPF;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewClienteDTO {
	
	@NotBlank(message = "O campo nome é requerido.")
	private String nome;
	
	@NotBlank(message = "O campo nome da Mãe é requerido.")
	private String nomeDaMae;
	
	@UnicoCPF(message = "Este CPF já consta cadastrado em nossa Base de dados.")
	@CPF(message = "Informe um CPF válido.")
	@NotBlank(message = "O campo CPF é requerido.")
	private String cpf;

	@Email(message = "e-Mail inválido")
	@NotBlank(message = "O campo e-mail é requerido.")
	private String email;

	@NotBlank(message = "O campo DDD é requerido.")
	private String ddd;
	
	@NotBlank(message = "O campo celular é requerido.")
	private String celular;

}
