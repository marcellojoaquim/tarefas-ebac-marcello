package com.vendas.online.dao;

import com.vendas.online.dao.generic.GenericDaoDB2;
import com.vendas.online.domain.Estoque;


public class EstoqueDAODB2 extends GenericDaoDB2<Estoque, String> implements IEstoqueDAO {

    public EstoqueDAODB2() {
        super(Estoque.class);
    }

}
