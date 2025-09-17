package com.mjsilva.cliente.usecases;

import org.springframework.stereotype.Service;

import com.mjsilva.cliente.domain.Cliente;
import com.mjsilva.cliente.repository.IClienteRepository;

import jakarta.validation.Valid;

@Service
public class CadastroCliente {
	
	private IClienteRepository clienteRepository;
	
	public CadastroCliente(IClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	public Cliente cadastrar(@Valid Cliente cliente) {
		return this.clienteRepository.insert(cliente);
	}
	
	public Cliente atualizar(@Valid Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
	
	public void remover(String id) {
		this.clienteRepository.deleteById(id);
	}
}
