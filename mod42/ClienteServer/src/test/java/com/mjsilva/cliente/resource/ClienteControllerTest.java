package com.mjsilva.cliente.resource;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mjsilva.cliente.domain.Cliente;
import com.mjsilva.cliente.usecases.BuscarCliente;
import com.mjsilva.cliente.usecases.CadastroCliente;

@WebMvcTest(ClienteController.class )
public class ClienteControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockitoBean
	private BuscarCliente buscarCliente;

	@MockitoBean
	private CadastroCliente cadastroCliente;

	private Cliente cliente;
	private String clienteJson;

	@BeforeEach
	void setUp() throws Exception{
		cliente = Cliente.builder().id("123456789987654321")
				.nome("CLiente teste").cpf(12345678900L)
				.email("email@email.com").telefone(12345678l)
				.endereco("rua teste")
				.numero(123).cidade("cidade teste")
				.estado("estado teste").build();
		
		clienteJson = objectMapper.writeValueAsString(cliente);
	}

	@Test
	@DisplayName("Deve retornar um cliente cadastrado")
	void cadastrarClienteTeste() throws Exception {
		
		when(cadastroCliente.cadastrar(any(Cliente.class))).thenReturn(cliente);

		mockMvc.perform(post("/cliente")
		.contentType(MediaType.APPLICATION_JSON)
		.content(clienteJson))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.id").value(cliente.getId()));
	}
	
	@Test
	@DisplayName("Deve retornar um cliente por id")
	void buscarClientePorId() throws Exception {
		
		when(buscarCliente.buscarPorId(anyString())).thenReturn(cliente);
		
		mockMvc.perform(get("/cliente/id")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.id").value(cliente.getId()));
	}
	
	@Test
	@DisplayName("Deve retornar um cliente por CPF")
	void buscarClientePorCpf() throws Exception {
		Long id = 1l;
		when(buscarCliente.buscarPorCpf(anyLong())).thenReturn(cliente);
		
		mockMvc.perform(get("/cliente/cpf/"+id)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.id").value(cliente.getId()));
	}
	
	@Test
	@DisplayName("Deve retornar um cliente atualizado")
	void atualizarClienteTeste() throws Exception {
		Cliente clienteAtualizado = Cliente.builder().id("123456789987654321")
				.nome("CLiente Atulizado").cpf(12345678900L)
				.email("emailAtualizado@email.com").telefone(12345678l)
				.endereco("rua teste")
				.numero(123).cidade("cidade teste")
				.estado("estado teste").build();
		
		clienteJson = objectMapper.writeValueAsString(clienteAtualizado);
		
		when(cadastroCliente.atualizar(any(Cliente.class))).thenReturn(clienteAtualizado);

		mockMvc.perform(put("/cliente")
		.contentType(MediaType.APPLICATION_JSON)
		.content(clienteJson))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.id").value(cliente.getId()))
		.andExpect(jsonPath("$.email").value(clienteAtualizado.getEmail()));
	}

}
