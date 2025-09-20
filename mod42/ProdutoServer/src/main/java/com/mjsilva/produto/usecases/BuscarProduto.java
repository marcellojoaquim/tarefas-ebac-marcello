package com.mjsilva.produto.usecases;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mjsilva.produto.domain.Produto;
import com.mjsilva.produto.domain.Produto.Status;
import com.mjsilva.produto.exception.EntityNotFoundException;
import com.mjsilva.produto.repository.IProdutoRepository;

@Service
public class BuscarProduto {
	
	private IProdutoRepository produtoRepository;
	
	
	public BuscarProduto(IProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public Page<Produto> buscar(Pageable pageable) {
		return produtoRepository.findAll(pageable);
	}
	
	public Page<Produto> buscar(Pageable pageable, Status status){
		return produtoRepository.findAllByStatus(pageable, status);
	}
	
	public Produto buscarPorCodigo(String codigo) {
		return produtoRepository.findByCodigo(codigo)
				.orElseThrow(() -> new EntityNotFoundException(Produto.class, "codigo", codigo));
	}
	
	public Produto buscarProId(String id) {
		return produtoRepository.findById(id)
				.orElseThrow(()-> new EntityNotFoundException(Produto.class, "id", id));
	}
}
