package com.vendas.online.services;

import com.vendas.online.domain.Cliente;
import com.vendas.online.exceptions.DAOException;
import com.vendas.online.services.generic.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {

    Cliente buscarPorCPF(Long cpf) throws DAOException;
}
