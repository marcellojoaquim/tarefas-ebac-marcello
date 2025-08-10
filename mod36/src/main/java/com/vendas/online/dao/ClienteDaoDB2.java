package com.vendas.online.dao;

import com.vendas.online.dao.generic.GenericDaoDB2;
import com.vendas.online.domain.Cliente;


public class ClienteDaoDB2 extends GenericDaoDB2<Cliente, Long> implements IClienteDAO {

    public ClienteDaoDB2() {
        super(Cliente.class);
    }

}