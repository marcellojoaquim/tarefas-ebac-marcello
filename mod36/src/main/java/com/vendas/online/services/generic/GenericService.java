package com.vendas.online.services.generic;

import com.vendas.online.dao.Persistente;
import com.vendas.online.dao.generic.IGenericDAO;
import com.vendas.online.exceptions.DAOException;
import com.vendas.online.exceptions.MaisDeUmRegistroException;
import com.vendas.online.exceptions.TableException;
import com.vendas.online.exceptions.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.util.Collection;

public class GenericService<T extends Persistente, E extends Serializable> implements IGenericService<T, E> {

    protected IGenericDAO<T, E> dao;

    public GenericService(IGenericDAO<T, E> dao) {
        this.dao = dao;
    }

    public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        return this.dao.cadastrar(entity);
    }

    @Override
    public void excluir(T entity) throws DAOException {
        this.dao.excluir(entity);
    }

    @Override
    public void alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        this.dao.alterar(entity);
    }

    @Override
    public T consultar(E valor) throws DAOException {
        try {
            return this.dao.consultar(valor);
        } catch (MaisDeUmRegistroException | TableException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Collection<T> buscarTodos() throws DAOException {
        return this.dao.buscarTodos();
    }
}
