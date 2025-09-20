package com.mjsilva.produto.usecases;

import org.springframework.stereotype.Service;

import com.mjsilva.produto.domain.Produto;
import com.mjsilva.produto.domain.Produto.Status;
import com.mjsilva.produto.exception.EntityNotFoundException;
import com.mjsilva.produto.repository.IProdutoRepository;

import jakarta.validation.Valid;

@Service
public class CadastrarProduto {

	private IProdutoRepository produtoRepository;
	
	public CadastrarProduto(IProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public Produto cadastrar(@Valid Produto produto) {
		produto.setStatus(Status.ATIVO);
		return this.produtoRepository.insert(produto);
	}
	
	public Produto atualizar(@Valid Produto produto) {
		return this.produtoRepository.save(produto);
	}
	
	public void remover(String id) {
		Produto prod = produtoRepository.findById(id)
				.orElseThrow(()->new EntityNotFoundException(Produto.class, "id", id));
		prod.setStatus(Status.INATIVO);
		this.produtoRepository.save(prod);
	}
}
