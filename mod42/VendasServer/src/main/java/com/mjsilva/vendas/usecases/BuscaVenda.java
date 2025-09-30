package com.mjsilva.vendas.usecases;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mjsilva.vendas.domain.Venda;
import com.mjsilva.vendas.exception.EntityNotFoundException;
import com.mjsilva.vendas.repository.IVendaRepository;

@Service
public class BuscaVenda {

private IVendaRepository vendaRepository;
	
	public BuscaVenda(IVendaRepository produtoRepository) {
		this.vendaRepository = produtoRepository;
	}
	
	public Page<Venda> buscar(Pageable pageable) {
		return vendaRepository.findAll(pageable);
	}

	public Venda buscarPorCodigo(String codigo) {
		return vendaRepository.findByCodigo(codigo)
				.orElseThrow(() -> new EntityNotFoundException(Venda.class, "codigo", codigo));
	}
}
