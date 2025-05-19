package dao.generic;

import java.util.Collection;

import domain.Persistence;

public interface IGenericDAO <T extends Persistence> {
  public Boolean cadastrar(T entity);
  public void excluir(Long codigo);
  public void alterar(T entity);
  public T consultar(Long codigo);
  public Collection<T> buscarTodos();
}
