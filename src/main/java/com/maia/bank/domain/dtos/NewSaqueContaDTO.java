package com.maia.bank.domain.dtos;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewSaqueContaDTO {
	
	@NotBlank(message = "O campo número de conta é requerido.")
	private Long numConta;
	
	@NotBlank(message = "O campo cpf de cliente é requerido.")
	private String cpfCliente;
	
	@NotBlank(message = "O campo valor para saque é requerido.")
	private Double valorSaque;
	
	

}
