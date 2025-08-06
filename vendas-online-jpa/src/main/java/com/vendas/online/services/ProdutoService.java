package com.vendas.online.services;

import com.vendas.online.dao.generic.IGenericDAO;
import com.vendas.online.domain.Produto;
import com.vendas.online.services.generic.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {
    public ProdutoService(IGenericDAO<Produto, String> dao) {
        super(dao);
    }
}
