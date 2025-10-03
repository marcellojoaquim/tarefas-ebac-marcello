package com.mjsilva.produto.usecases;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mjsilva.produto.domain.Produto;
import com.mjsilva.produto.repository.IProdutoRepository;

@ExtendWith(MockitoExtension.class)
public class CadastroProdutoTest {
	
	@Mock
	IProdutoRepository produtoRepository;

	@InjectMocks
	CadastrarProduto cadastrarProduto;
	
	private Produto produto1;
	private Produto produtoAtualizado;
	private final com.mjsilva.produto.domain.Produto.Status statusAtivo = com.mjsilva.produto.domain.Produto.Status.ATIVO;
	private final com.mjsilva.produto.domain.Produto.Status statusInativo = com.mjsilva.produto.domain.Produto.Status.ATIVO;
	
	@BeforeEach
	void setUp() {
		produto1 = Produto.builder()
				.id("1234567899")
				.nome("Produto 1")
				.codigo("1234A")
				.descricao("Produto teste 01")
				.status(statusAtivo)
				.valor(BigDecimal.valueOf(150)).build();
		
	}
	
	@Test
	@DisplayName("Deve cadastrar um produto")
	void cadastrarProduto() {
		when(produtoRepository.insert(produto1)).thenReturn(produto1);
		
		Produto result = cadastrarProduto.cadastrar(produto1);
		
		Mockito.verify(produtoRepository, times(1)).insert(produto1);
		assertNotNull(result);
		assertEquals(produto1.getNome(), result.getNome());
	}
	
	@Test
	@DisplayName("Deve atualizar um produto")
	void atualizarProduto(){
		produtoAtualizado = Produto.builder()
				.nome("Produto 2")
				.codigo("1234B")
				.descricao("Produto teste 02")
				.status(statusInativo)
				.valor(BigDecimal.valueOf(130)).build();
		
		when(produtoRepository.save(produtoAtualizado)).thenReturn(produtoAtualizado);
		
		Produto result = cadastrarProduto.atualizar(produtoAtualizado);
		
		Mockito.verify(produtoRepository, times(1)).save(produtoAtualizado);
		assertNotNull(result);
		assertEquals(produtoAtualizado.getNome(), result.getNome());
		
	}
	
	@Test
	@DisplayName("Remover produto")
	void removerProduto() {
		when(produtoRepository.findById(produto1.getId())).thenReturn(Optional.of(produto1));
		
		cadastrarProduto.remover(produto1.getId());
		Mockito.verify(produtoRepository, times(1)).save(produto1);
	}
	
}
