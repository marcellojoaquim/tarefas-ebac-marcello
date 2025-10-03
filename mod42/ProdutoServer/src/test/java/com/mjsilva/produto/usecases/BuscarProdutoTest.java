package com.mjsilva.produto.usecases;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.mjsilva.produto.domain.Produto;
import com.mjsilva.produto.domain.Produto.Status;
import com.mjsilva.produto.exception.EntityNotFoundException;
import com.mjsilva.produto.repository.IProdutoRepository;

@ExtendWith(MockitoExtension.class)
public class BuscarProdutoTest {
	
	@InjectMocks
	BuscarProduto buscarProduto;
	
	@Mock
	IProdutoRepository produtoRepository;
	
	private Produto produto;
	private Produto produto2;
	private static Produto.Status status;
	
	@BeforeEach
	void setUp() {
		produto = Produto.builder()
				.id("123456789")
				.nome("Produto 1")
				.codigo("1234A")
				.status(Status.ATIVO)
				.descricao("produto Ativo")
				.valor(BigDecimal.valueOf(150))
				.build();
		
		produto2 = Produto.builder()
				.id("1234567")
				.nome("Produto 2")
				.codigo("1234A")
				.status(Status.INATIVO)
				.descricao("produto 2 Ativo")
				.valor(BigDecimal.valueOf(200))
				.build();
	}
	
	@Test
	@DisplayName("Deve retornar todos os produtos")
	void buscarTodosOsProdutos() {
		List<Produto> produtos = List.of(produto, produto2);
		Pageable pageable = PageRequest.of(0, 10);
		Page<Produto> produtoPage = new PageImpl<>(produtos, pageable, produtos.size());
		
		when(produtoRepository.findAll(pageable)).thenReturn(produtoPage);
		Page<Produto> results = buscarProduto.buscar(pageable);
		
		assertNotNull(results);
		assertEquals(2, results.getContent().size());
	}
	
	@Test
	@DisplayName("Deve retornar um produto")
	void buscarProdutoPorCodigo() {
		when(produtoRepository.findByCodigo(anyString())).thenReturn(Optional.of(produto));
		
		Produto result = buscarProduto.buscarPorCodigo("12345");
		assertNotNull(result);
		assertEquals(produto.getCodigo(), result.getCodigo());
	}
	
	@Test
	@DisplayName("Deve retornar o produto de acordo com o status")
	void buscarProdutoDeAcordoComStatus() {
		List<Produto> produtos = List.of(produto, produto2);
		Pageable pageable = PageRequest.of(0, 10);
		Page<Produto> produtoPage = new PageImpl<>(produtos, pageable, produtos.size());
		
		when(produtoRepository.findAllByStatus(pageable, Status.ATIVO)).thenReturn(produtoPage);
		
		Page<Produto> results = buscarProduto.buscarPorStatus(pageable, status.ATIVO);
		
		assertNotNull(results);
		assertEquals(produto.getCodigo(), results.getContent().get(0).getCodigo());
	}
	
	@Test
	@DisplayName("Deve retornar prodito pelo Id")
	void buscarProdutoPorId() {
		when(produtoRepository.findById(anyString())).thenReturn(Optional.of(produto));
		
		Produto result = buscarProduto.buscarPorId("12345");
		assertNotNull(result);
		assertEquals(produto.getCodigo(), result.getCodigo());
	}
	
	@Test
	@DisplayName("Deve lançar EntityNotFound quando não encontrar por codigo")
	void deveLancarExceptionAoBuscarProdutoProCodigo() {
		when(produtoRepository.findByCodigo(anyString()))
				.thenReturn(Optional.empty());
		
		EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, ()->{
			buscarProduto.buscarPorCodigo("123");
		},"Deve lançar exception");
		
		String msg = "Produto was not found for parameters "+"{codigo=123}";
		
		assertEquals(msg, exception.getMessage());
	}
	
	@Test
	@DisplayName("Deve lançar EntityNotFound quando não encontrar por codigo")
	void deveLancarExceptionAoBuscarProdutoProId() {
		when(produtoRepository.findById(anyString()))
				.thenReturn(Optional.empty());
		
		EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, ()->{
			buscarProduto.buscarPorId("123");
		},"Deve lançar exception");
		
		String msg = "Produto was not found for parameters "+"{id=123}";
		
		assertEquals(msg, exception.getMessage());
	}
}
