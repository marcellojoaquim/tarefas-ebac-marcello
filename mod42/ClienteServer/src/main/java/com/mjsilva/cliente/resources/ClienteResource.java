package com.mjsilva.cliente.resources;


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

import com.mjsilva.cliente.domain.Cliente;
import com.mjsilva.cliente.usecases.BuscarCliente;
import com.mjsilva.cliente.usecases.CadastroCliente;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value="/cliente")
public class ClienteResource {
	
	private BuscarCliente buscarCliente;
	private CadastroCliente cadastroCliente;
	
	public ClienteResource(BuscarCliente buscarCliente,
			CadastroCliente cadastroCliente) {
		this.buscarCliente = buscarCliente;
		this.cadastroCliente = cadastroCliente;
	}
	
	
	@GetMapping
	@Operation(summary = "Buscar todos")
	public ResponseEntity<Page<Cliente>> buscar(
			@Parameter(description = "Objeto de paginação") Pageable pageable){
		return ResponseEntity.ok(buscarCliente.buscar(pageable));
	}
	
	@GetMapping(value="/{id}")
	@Operation(summary = "Buscar por id")
	public ResponseEntity<Cliente> buscarPorId(
			@Parameter(description="String ID") @PathVariable(value = "id", required = true) String id) {
		return ResponseEntity.ok(buscarCliente.buscarPorId(id));
	}
	
	@GetMapping(value="/cpf/{cpf}")
	@Operation(summary = "Buscar por cpf")
	public ResponseEntity<Cliente> buscarPorCpf(
			@Parameter(description="Long cpf") @PathVariable(value = "cpf", required = true) Long cpf) {
		return ResponseEntity.ok(buscarCliente.buscarPorCpf(cpf));
	}
	
	@PostMapping
	@Operation(summary = "Cadastra cliente")
	public ResponseEntity<Cliente> cadastrar(@RequestBody @Valid Cliente cliente){
		return ResponseEntity.ok(cadastroCliente.cadastrar(cliente));
	}
	
	@PutMapping
	@Operation(summary="Atualizar cliente")
	public ResponseEntity<Cliente> atualizar(@RequestBody @Valid Cliente cliente) {
		return ResponseEntity.ok(cadastroCliente.atualizar(cliente));
	}
}
