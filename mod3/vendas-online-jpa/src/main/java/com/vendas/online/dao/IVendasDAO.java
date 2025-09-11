package com.vendas.online.dao;

import com.vendas.online.dao.generic.IGenericDAO;
import com.vendas.online.domain.Venda;
import com.vendas.online.exceptions.DAOException;
import com.vendas.online.exceptions.TipoChaveNaoEncontradaException;

public interface IVendasDAO extends IGenericDAO<Venda, String> {

    void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
    void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
    public Venda consultarComCollection(Long id);
}
