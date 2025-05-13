package javaapplication1.dao;

import java.util.Collection;

import javaapplication1.domain.Cliente;

public interface IClienteDAO {

  public Boolean cadastrar(Cliente cliente);
  public void excluir(Long cpf);
  public void alterar(Cliente cliente);
  public Cliente consultar(Long cpf);
  public Collection<Cliente> buscarTodos();
}
