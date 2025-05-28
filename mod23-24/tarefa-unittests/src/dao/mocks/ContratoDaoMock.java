package dao.mocks;

import dao.IContratoDao;

public class ContratoDaoMock implements IContratoDao{

  @Override
  public String salvar() {
    return "Sucesso";
  }

  @Override
  public String buscar() {
    return "Secesso";
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
