package com.vendas.online.service.generic;

import java.io.Serializable;
import java.util.Collection;

import com.vendas.online.domain.Persistente;
import com.vendas.online.exceptions.DaoException;
import com.vendas.online.exceptions.MaisDeUmRegistroException;
import com.vendas.online.exceptions.TableException;
import com.vendas.online.exceptions.TipoChaveNaoEncontradaException;

public interface IGenericService<T extends Persistente, E extends Serializable>{
	
	public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DaoException;

    public void excluir(T entity) throws DaoException;

    public T alterar(T entity) throws TipoChaveNaoEncontradaException, DaoException;

    public T consultar(E valor) throws MaisDeUmRegistroException, TableException, DaoException;

    public Collection<T> buscarTodos() throws DaoException;

}
