package dao;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import domain.Cliente;

public class ClienteSetDAO implements IClienteDAO{

  private Set<Cliente> set;

  public ClienteSetDAO() {
    this.set = new HashSet<>();
  }

  @Override
  public Boolean cadastrar(Cliente cliente) {
    return this.set.add(cliente);
  }

  @Override
  public void excluir(Long cpf) {
    Cliente clienteExcluir = null;
    for (Cliente cliente : this.set) {
      if(cliente.getCpf().equals(cpf)) {
        clienteExcluir = cliente;
        break;
      }
    }

    if (clienteExcluir != null) {
      this.set.remove(clienteExcluir);
    }
  }

  @Override
  public void alterar(Cliente clienteConsulta) {
    if(this.set.contains(clienteConsulta)) {
      for (Cliente cliente : set) {
        if (cliente.equals(clienteConsulta)) {
          cliente.setCidade(clienteConsulta.getCidade());
          cliente.setEnd(clienteConsulta.getEnd());
          cliente.setEstado(clienteConsulta.getEstado());
          cliente.setNome(clienteConsulta.getNome());
          cliente.setNumero(clienteConsulta.getNumero());
          cliente.setTel(clienteConsulta.getTel());
        }
      }
    }
    
  }

  @Override
  public Cliente consultar(Long cpf) {
    for (Cliente cliente : this.set) {
      if (cliente.getCpf().equals(cpf)) {
        return cliente;
      }
    }

    return null;
  }

  @Override
  public Collection<Cliente> buscarTodos() {
    return this.set;
  }

}
