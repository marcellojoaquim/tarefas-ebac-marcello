package com.vendas.online.dao;

import com.vendas.online.dao.generic.GenericDaoDB2;
import com.vendas.online.domain.Produto;

public class ProdutoDAODB2 extends GenericDaoDB2<Produto, String> implements IProdutoDAO {

    public ProdutoDAODB2() {
        super(Produto.class);
    }

}
