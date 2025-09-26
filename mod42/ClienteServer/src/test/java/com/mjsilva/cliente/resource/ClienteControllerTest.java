package com.mjsilva.cliente.resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.mjsilva.cliente.domain.Cliente;
import com.mjsilva.cliente.usecases.BuscarCliente;
import com.mjsilva.cliente.usecases.CadastroCliente;

@AutoConfigureMockMvc
@WebMvcTest(controllers = {ClienteController.class})
public class ClienteControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@InjectMocks
	ClienteController clienteController;
	
	@MockitoBean
	BuscarCliente buscarCliente;
	
	@MockitoBean
	CadastroCliente cadastroCliente;
	
	@Test
	@DisplayName("Deve retornar um cliente cadastrado")
	void cadastrarClienteTeste() {
		Cliente cliente = Cliente.builder().id("123456789987654321").nome("CLiente teste")
				.cpf(12345678900L).email("email@email.com").endereco("rua teste").numero(123)
				.cidade("cidade teste").estado("estado teste").build();
		
		when(cadastroCliente.cadastrar(cliente)).thenReturn(cliente);
		
		ResponseEntity<Cliente> result = clienteController.cadastrar(cliente);
		
		assertEquals(cliente.getCpf(), result.getBody().getCpf());
	}
}
