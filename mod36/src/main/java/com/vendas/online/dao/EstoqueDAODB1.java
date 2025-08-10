package com.vendas.online.dao;

import com.vendas.online.dao.generic.GenericDaoDB1;
import com.vendas.online.domain.Estoque;


public class EstoqueDAODB1 extends GenericDaoDB1<Estoque, String> implements IEstoqueDAO {

    public EstoqueDAODB1() {
        super(Estoque.class);
    }

}
