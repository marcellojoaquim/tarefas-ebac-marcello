package com.vendas.online.dao;

import com.vendas.online.dao.generic.GenericDAO;
import com.vendas.online.domain.Estoque;


public class EstoqueDAO extends GenericDAO<Estoque, String> implements IEstoqueDAO {

    public EstoqueDAO() {
        super(Estoque.class);
    }

}
