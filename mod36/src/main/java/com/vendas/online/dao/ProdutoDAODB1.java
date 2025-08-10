package com.vendas.online.dao;

import com.vendas.online.dao.generic.GenericDaoDB1;
import com.vendas.online.domain.Produto;

public class ProdutoDAODB1 extends GenericDaoDB1<Produto, String> implements IProdutoDAO {

    public ProdutoDAODB1() {
        super(Produto.class);
    }

}
