package com.vendas.online.dao;


import javax.enterprise.context.ApplicationScoped;

import com.vendas.online.dao.generic.GenericDao;
import com.vendas.online.domain.Cliente;

@ApplicationScoped
public class ClienteDao extends GenericDao<Cliente, Long> implements IClienteDao{
	

	public ClienteDao() {
		super(Cliente.class);
	}

}
