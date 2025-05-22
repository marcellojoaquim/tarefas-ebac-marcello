package dao;

import dao.generic.GenericDAO;
import domain.Cliente;

public class ClienteMapDAO extends GenericDAO<Cliente> implements IClienteDAO  {

  public ClienteMapDAO() {
    super();
  }

  @Override
  public Class<Cliente> getTipoClasse() {
    return Cliente.class;
  }

  @Override
  public void atualizaDados(Cliente entity, Cliente clientCadastrado) {
      clientCadastrado.setNome(entity.getNome());
      clientCadastrado.setCpf(entity.getCpf());
      clientCadastrado.setEnd(entity.getEnd());
      clientCadastrado.setNumero(entity.getNumero());
      clientCadastrado.setCidade(entity.getCidade());
      clientCadastrado.setEstado(entity.getEstado());
      clientCadastrado.setTel(entity.getTel());
  }
}
