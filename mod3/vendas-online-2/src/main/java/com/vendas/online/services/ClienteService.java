package com.vendas.online.services;

import com.vendas.online.dao.generic.IGenericDAO;
import com.vendas.online.domain.Cliente;
import com.vendas.online.exceptions.DAOException;
import com.vendas.online.exceptions.MaisDeUmRegistroException;
import com.vendas.online.exceptions.TableException;
import com.vendas.online.services.generic.GenericService;

public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {

    public ClienteService(IGenericDAO<Cliente, Long> dao) {
        super(dao);
    }

    @Override
    public Cliente buscarPorCPF(Long cpf) throws DAOException {
        try {
            return this.dao.consultar(cpf);
        } catch (MaisDeUmRegistroException | TableException e ) {
            e.printStackTrace();
        }
        return null;
    }
}
