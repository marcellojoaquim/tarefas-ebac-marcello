package com.vendas.online.service;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.vendas.online.dao.IClienteDao;
import com.vendas.online.domain.Cliente;
import com.vendas.online.exceptions.DaoException;
import com.vendas.online.exceptions.MaisDeUmRegistroException;
import com.vendas.online.exceptions.TableException;
import com.vendas.online.service.generic.GenericService;

@ApplicationScoped
public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {

	@Inject
	public ClienteService(IClienteDao clienteDao) {
		super(clienteDao);
	}

	@Override
	public Cliente buscarPorCpf(Long cpf) throws DaoException {
		try {
			return this.dao.consultar(cpf);
		} catch (MaisDeUmRegistroException | TableException e) {
			e.printStackTrace();
		}
		return null;
	}

}
