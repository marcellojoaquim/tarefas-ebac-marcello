package com.vendas.online.service;


import javax.enterprise.context.ApplicationScoped;

import com.vendas.online.domain.Cliente;
import com.vendas.online.exceptions.DaoException;
import com.vendas.online.service.generic.IGenericService;

@ApplicationScoped
public interface IClienteService extends IGenericService<Cliente, Long> {
	
	Cliente buscarPorCpf(Long cpf) throws DaoException;

}
