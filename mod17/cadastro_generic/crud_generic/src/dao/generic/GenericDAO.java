package dao.generic;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import domain.Persistence;

public abstract class GenericDAO<T extends Persistence> implements IGenericDAO<T>{

  protected Map<Class<T>, Map<Long, T>> map;

  public GenericDAO() {
    this.map = new HashMap<>();
     Map<Long, T> mapaInterno = this.map.get(getTipoClasse());
    if(mapaInterno == null) {
      mapaInterno = new HashMap<>();
      this.map.put(getTipoClasse(), mapaInterno);
    }
  }

  @Override
  public void alterar(T entity) {
    Map<Long, T> mapaInterno = this.map.get(getTipoClasse());
    T objetoCadastrado = mapaInterno.get(entity.getCodigo());
    if(objetoCadastrado != null){
      atualizaDados(entity, objetoCadastrado);
    }
  }

  @Override
  public Collection<T> buscarTodos() {
    Map<Long, T> mapaInterno = this.map.get(getTipoClasse());
    return mapaInterno.values();
  }

  @Override
  public Boolean cadastrar(T entity) {
    Map<Long, T> mapaInterno = this.map.get(getTipoClasse());
    if(mapaInterno.containsKey(entity.getCodigo())){
      return false;
    }
    mapaInterno.put(entity.getCodigo(), entity);
    return true;
  }

  @Override
  public T consultar(Long codigo) {
    Map<Long, T> mapaInterno = this.map.get(getTipoClasse());
    T objetoConsult = mapaInterno.get(codigo);
    if(objetoConsult != null) return null;

    return objetoConsult;
  }

  @Override
  public void excluir(Long codigo) {
    Map<Long, T> mapaInterno = this.map.get(getTipoClasse());
    T objetoCadas = mapaInterno.get(codigo);
    if(objetoCadas != null) {
      this.map.remove(codigo, objetoCadas);
    }
  }

  public abstract Class<T> getTipoClasse();

  public abstract void atualizaDados(T entity, T entityCadastrado);
  
}
