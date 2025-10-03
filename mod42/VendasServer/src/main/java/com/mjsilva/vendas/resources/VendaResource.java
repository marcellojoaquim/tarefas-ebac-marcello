package com.mjsilva.vendas.resources;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjsilva.vendas.domain.Venda;
import com.mjsilva.vendas.dto.VendaDto;
import com.mjsilva.vendas.usecases.BuscaVenda;
import com.mjsilva.vendas.usecases.CadastroVenda;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/venda")
public class VendaResource {

	private BuscaVenda buscaVenda;
	private CadastroVenda cadastroVenda;
	
	public VendaResource(BuscaVenda buscaVenda, CadastroVenda cadastroVenda) {
		this.buscaVenda = buscaVenda;
		this.cadastroVenda = cadastroVenda;
	}
	
	@GetMapping
	@Operation(summary = "Buscar vendas")
	public ResponseEntity<Page<Venda>> buscar(Pageable pageable){
		return ResponseEntity.ok(buscaVenda.buscar(pageable));
	}
	
	@GetMapping(value = "/{codigo}")
	@Operation(summary = "Buscar venda por código")
	public ResponseEntity<Venda> buscarPorCodigo(@PathVariable(value = "codigo") String codigo){
		return ResponseEntity.ok(buscaVenda.buscarPorCodigo(codigo));
	}
	
	@PostMapping
	@Operation(summary = "Inicia venda")
	public ResponseEntity<Venda> cadastrar(@RequestBody @Valid VendaDto vendaDto) {
		return ResponseEntity.ok(cadastroVenda.cadastrar(vendaDto));
	}
	
	@PutMapping(value = "/{id}/{codigoProduto}/{quantidade}")
	public ResponseEntity<Venda> adicionarProduto(
			@PathVariable(value = "id", required = true) String id, 
			@PathVariable(value = "codigoProduto") String codigoProduto, 
			@PathVariable(value = "quantidade") Integer quantidade) {
		return ResponseEntity.ok(cadastroVenda.adicionarProduto(id, codigoProduto, quantidade));
	}
}
