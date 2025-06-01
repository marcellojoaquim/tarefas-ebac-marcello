package services.generics;

import anotacao.TipoChave;
import dao.generics.IGenericDAO;
import dao.generics.SingletonMap;
import domain.Persistente;
import exception.TipoChaveNaoEncontradaException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public abstract class GenericService<T extends Persistente> implements IGenericService<T> {

    protected IGenericDAO<T> dao;

    public GenericService(IGenericDAO<T> dao) {
        this.dao = dao;
    }

    @Override
    public Boolean salvar(T entity) throws TipoChaveNaoEncontradaException {
        return dao.cadastrar(entity);
    }

    @Override
    public T buscarPorCodigo(Long valor) {
       return dao.consultar(valor);
    }

    @Override
    public void excluir(Long valor) {
            dao.excluir(valor);
    }

    @Override
    public void alterar(T entity) throws TipoChaveNaoEncontradaException {
        this.dao.alterar(entity);
    }
}
