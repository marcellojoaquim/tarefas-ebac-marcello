package com.mjsilva.cliente.usecases;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mjsilva.cliente.domain.Cliente;
import com.mjsilva.cliente.exception.EntityNotFoundException;
import com.mjsilva.cliente.repository.IClienteRepository;


@ExtendWith(MockitoExtension.class)
public class BuscarClienteTest {
	
	@InjectMocks
	BuscarCliente buscarCliente;
	
	
	@Mock
	IClienteRepository clienteRepository;
	
	private Cliente cliente;
	private Long cpfNaoExiste = 123456789l;
	
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
	@DisplayName("Deve restornar um cliente por CPF")
	void buscarClientePorCPFTest() {
		when(clienteRepository.findByCpf(12345678900l))
        .thenReturn(Optional.of(cliente));
		
		
		Cliente result = buscarCliente.buscarPorCpf(12345678900l);
		
		assertNotNull(result);
		assertEquals(result.getCpf(), cliente.getCpf());
		assertEquals(result.getEmail(), cliente.getEmail());
		assertEquals(result.getNome(), cliente.getNome());
		
	}
	
	@Test
	@DisplayName("Deve lançar EntityNotFoundException quando não encontrado")
	void erroAoBbuscarPorCpf() {
		
		when(clienteRepository.findByCpf(cpfNaoExiste))
			.thenReturn(Optional.empty());
		
		EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> {
			buscarCliente.buscarPorCpf(cpfNaoExiste);
		}, "Deve lançar exceção");
		
		String msg = "Cliente was not found for parameters " + "{cpf="+ cpfNaoExiste+"}";
		
		assertEquals(msg, exception.getMessage());
	}
	
	@Test
	@DisplayName("Deve retornar cliente por Id")
	void buscarPorId() {
		
		when(clienteRepository.findById("123456789987654321"))
			.thenReturn(Optional.of(cliente));
		
		Cliente result = buscarCliente.buscarPorId("123456789987654321");
		assertNotNull(result);
		assertEquals(result.getCpf(), cliente.getCpf());
		assertEquals(result.getEmail(), cliente.getEmail());
		assertEquals(result.getNome(), cliente.getNome());
	}
}
