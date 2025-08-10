package com.vendas.online.dao;

import com.vendas.online.dao.generic.GenericDaoDB1;
import com.vendas.online.domain.Cliente;


public class ClienteDaoDB1 extends GenericDaoDB1<Cliente, Long> implements IClienteDAO {

    public ClienteDaoDB1() {
        super(Cliente.class);
    }

}