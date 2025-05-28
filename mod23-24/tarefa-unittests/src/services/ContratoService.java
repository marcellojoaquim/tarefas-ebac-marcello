package services;

import dao.IContratoDao;

public class ContratoService implements IContratoService {

  private IContratoDao contratoDao;

  public ContratoService(IContratoDao dao) {
      this.contratoDao = dao;
  }

  @Override
  public String salvar() {
      contratoDao.salvar();
      return "Sucesso";
  }

  @Override
  public String buscar() {
    return "Sucesso";
  }

  @Override
  public boolean excluir() {
    return true;
  }

  @Override
  public String atualizar() {
    return "Sucesso";
  }
}