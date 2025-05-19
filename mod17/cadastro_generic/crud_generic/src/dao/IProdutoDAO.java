package dao;

import java.util.Collection;

import domain.Produto;

public interface IProdutoDAO {
  public Boolean cadastrar(Produto produto);
  public void excluir(Long codigo);
  public void alterar(Produto produto);
  public Produto consultar(Long codigo);
  public Collection<Produto> buscarTodos();
}
