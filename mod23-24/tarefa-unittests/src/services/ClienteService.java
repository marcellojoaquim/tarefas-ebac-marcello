package services;

import dao.IClienteDao;

public class ClienteService {

  private IClienteDao clienteDao;

  public ClienteService(IClienteDao clienteDao) {
    // clienteDao = new ClienteDao();
    // clienteDao = new ClienteDaoMock();
    this.clienteDao = clienteDao;
  }

  public String salvar() {
    clienteDao.salvar();
    return "Sucesso";
  }

  // TODO
  // Fazer métodos de buscar, excluir e atualizar
  public String buscar() {
    clienteDao.buscar();
    return "Sucesso";
  }

  public boolean excluir() {
    clienteDao.excluir();
    return true;
  }

  public String atualizar() {
    clienteDao.atualizar();
    return "Sucesso";
  }
}