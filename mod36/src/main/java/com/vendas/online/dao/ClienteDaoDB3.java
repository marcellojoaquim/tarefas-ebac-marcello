package com.vendas.online.dao;

import com.vendas.online.dao.generic.GenericDaoDB2;
import com.vendas.online.dao.generic.GenericDaoDB3;
import com.vendas.online.domain.Cliente;


public class ClienteDaoDB3 extends GenericDaoDB3<Cliente, Long> implements IClienteDAO {

    public ClienteDaoDB3() {
        super(Cliente.class);
    }

}