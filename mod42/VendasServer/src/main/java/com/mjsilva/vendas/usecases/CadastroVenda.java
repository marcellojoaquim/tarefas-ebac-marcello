package com.mjsilva.vendas.usecases;

import java.math.BigDecimal;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjsilva.vendas.domain.Produto;
import com.mjsilva.vendas.domain.Venda;
import com.mjsilva.vendas.domain.Venda.Status;
import com.mjsilva.vendas.dto.VendaDto;
import com.mjsilva.vendas.exception.EntityNotFoundException;
import com.mjsilva.vendas.repository.IVendaRepository;
import com.mjsilva.vendas.service.ClienteService;
import com.mjsilva.vendas.service.IProdutoService;

import jakarta.validation.Valid;

@Service
public class CadastroVenda {

	private IVendaRepository vendaRepository;
	
	private IProdutoService produtoService;
	
	private ClienteService clienteService;
	
	public CadastroVenda(IVendaRepository produtoRepository,
			IProdutoService produtoService,
			ClienteService clienteService) {
		this.vendaRepository = produtoRepository;
		this.produtoService = produtoService;
		this.clienteService = clienteService;
	}
	
	public Venda cadastrar(@Valid VendaDto vendaDTO) {
		Venda venda = convertToDomain(vendaDTO, Status.INICIADA);
		validarCliente(venda.getClienteId());
		venda.recalcularValorTotalVenda();
		return this.vendaRepository.insert(venda);
	}

	private void validarCliente(String clienteId) {
		Boolean isCadastrado = 
				this.clienteService.isClienteCadastrado(clienteId);
		if (!isCadastrado) {
			new EntityNotFoundException(Venda.class, "clienteId", clienteId);
		}
	}

	private Venda convertToDomain(@Valid VendaDto vendaDTO, Status status) {
		return Venda.builder()
				.clienteId(vendaDTO.getClienteId())
				.codigo(vendaDTO.getCodigo())
				.dataVenda(vendaDTO.getDataVenda())
				.status(status)
				.valorTotal(BigDecimal.ZERO)
				.produtos(new HashSet<>())
				.build();
	}

	public Venda atualizar(@Valid Venda venda) {
		return this.vendaRepository.save(venda);
	}

	public Venda finalizar(String id) {
		Venda venda = buscarVenda(id);
		venda.validarStatus();
		venda.setStatus(Status.CONCLUIDA);
		return this.vendaRepository.save(venda);
	}
	
	public Venda cancelar(String id) {
		Venda venda = buscarVenda(id);
		venda.validarStatus();
		venda.setStatus(Status.CANCELADA);
		return this.vendaRepository.save(venda);
	}

	public Venda adicionarProduto(String id, String codigoProduto, Integer quantidade) {
		Venda venda = buscarVenda(id);
		Produto produto = buscarProduto(codigoProduto);
		venda.validarStatus();
		venda.adicionarProduto(produto, quantidade);
		return this.vendaRepository.save(venda);
	}
	
	public Venda removerProduto(String id, String codigoProduto, Integer quantidade) {
		Venda venda = buscarVenda(id);
		Produto produto = buscarProduto(codigoProduto);
		venda.validarStatus();
		venda.removerProduto(produto, quantidade);
		return this.vendaRepository.save(venda);
	}
	
	private Venda buscarVenda(String id) {
		return vendaRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(Venda.class, "id", id));
		
	}
	
	private Produto buscarProduto(String codigoProduto) {
		Produto prod = produtoService.buscarProduto(codigoProduto);
		if (prod == null) {
			throw new EntityNotFoundException(Produto.class, "codigo", codigoProduto);
		}
		return prod;
	}

}
