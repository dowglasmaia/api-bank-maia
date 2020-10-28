package com.maia.bank.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.maia.bank.domain.Cliente;
import com.maia.bank.repository.ClienteRepository;
import com.maia.bank.services.impl.ClienteServicesImpl;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("tests")
public class ClienteServicesTests {
	
	
	ClienteServices clienteServices;
	
	@MockBean
	ClienteRepository repository;
	
	@BeforeEach
	public void setUp() {
		this.clienteServices = new ClienteServicesImpl(repository);
	}
	
	
	public static Cliente createCliente() {
		return Cliente.builder()
				.id(1l)
				.nome("DK Maia")
				.cpf("83658134836")
				.email("maia@maia.ok")
				.nomeDaMae("Nome da Mãe")
				.ddd("41")
				.celular("974123698")
				.build();
	}
	
	
	@Test
	@DisplayName("Deve Salvar um novo Cliente na base de Dados")
	public void saveCliente() {
		//cenario
		Cliente entity = createCliente();
		
		when(repository.save(entity)).thenReturn(
				createCliente() );
		//execução
		Cliente savedCliente = clienteServices.save(entity);
		
		//verificação
		assertThat(savedCliente.getId()).isNotNull();
		assertThat(savedCliente.getNome()).isEqualTo("DK Maia");
		assertThat(savedCliente.getNomeDaMae()).isEqualTo("Nome da Mãe");
		assertThat(savedCliente.getCpf()).isEqualTo("83658134836");
		
		Mockito.verify(repository, Mockito.times(1)).save(entity); // verifica se passou neste metodo ao menos UMA VEZ(1X).
			
		
	}

}
