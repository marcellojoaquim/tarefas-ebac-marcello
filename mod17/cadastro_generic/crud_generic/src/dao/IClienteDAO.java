package dao;

import java.util.Collection;

import dao.generic.IGenericDAO;
import domain.Cliente;

public interface IClienteDAO  extends IGenericDAO<Cliente>{

  public Boolean cadastrar(Cliente cliente);
  public void excluir(Long cpf);
  public void alterar(Cliente cliente);
  public Cliente consultar(Long cpf);
  public Collection<Cliente> buscarTodos();
}
