package com.vendas.online.dao;

import com.vendas.online.dao.generic.IGenericDAO;
import com.vendas.online.domain.Venda;
import com.vendas.online.exceptions.DAOException;
import com.vendas.online.exceptions.TipoChaveNaoEncontradaException;

public interface IVendasDAO extends IGenericDAO<Venda, String> {

    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
    public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
