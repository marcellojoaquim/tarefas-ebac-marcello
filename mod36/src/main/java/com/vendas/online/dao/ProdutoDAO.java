package com.vendas.online.dao;

import com.vendas.online.dao.generic.GenericDAO;
import com.vendas.online.domain.Produto;

public class ProdutoDAO extends GenericDAO<Produto, String> implements IProdutoDAO {

    public ProdutoDAO() {
        super(Produto.class);
    }

}
