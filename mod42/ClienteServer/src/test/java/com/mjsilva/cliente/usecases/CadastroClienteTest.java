package com.mjsilva.cliente.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mjsilva.cliente.domain.Cliente;
import com.mjsilva.cliente.repository.IClienteRepository;

@ExtendWith(MockitoExtension.class)
public class CadastroClienteTest {

	@Mock
	IClienteRepository clienteRepository;
	
	@InjectMocks
	CadastroCliente cadastroCliente;
	
	private Cliente cliente;
	
	@BeforeEach
	void setUp() {
		cliente = Cliente.builder()
				.id("123456789987654321")
				.nome("CLiente teste")
				.cpf(12345678900L)
				.email("email@email.com")
				.endereco("rua teste")
				.numero(123)
				.cidade("cidade teste")
				.estado("estado teste")
				.build();
	}
	
	@Test
	@DisplayName("Cadastro de cliente com sucesso")
	void cadastrarCliente() {
		
		when(clienteRepository.insert(cliente))
			.thenReturn(cliente);
		
		Cliente result = cadastroCliente.cadastrar(cliente);
		
		Mockito.verify(clienteRepository).insert(cliente);
		assertNotNull(result);
		assertEquals(cliente.getCpf(), result.getCpf());
		assertEquals(cliente.getNome(), result.getNome());
	}
	
	@Test
	@DisplayName("Atualização de cliente com sucesso")
	void atualizarCliente() {
		
		Cliente clienteAtualizado = Cliente.builder()
				.id("123456789987654321")
				.nome("CLiente teste")
				.cpf(12345678900L)
				.email("email@email.com")
				.endereco("rua teste")
				.numero(123)
				.cidade("cidade teste")
				.estado("estado teste")
				.build();
		
		when(clienteRepository.save(clienteAtualizado))
			.thenReturn(clienteAtualizado);
		
		Cliente result = cadastroCliente.atualizar(clienteAtualizado);
		
		Mockito.verify(clienteRepository).save(clienteAtualizado);
		assertNotNull(result);
		assertEquals(clienteAtualizado.getCpf(), result.getCpf());
		assertEquals(clienteAtualizado.getNome(), result.getNome());
	}
	
	@Test
	@DisplayName("Remocao de cliente com sucesso")
	void removerCliente() {
		
		doNothing().when(clienteRepository)
			.deleteById(cliente.getId());
		
		cadastroCliente.remover(cliente.getId());
		
		Mockito.verify(clienteRepository, times(1)).deleteById(cliente.getId());
	
	}
	
	
}
