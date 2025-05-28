package dao;

public class ClienteDao implements IClienteDao {

    @Override
  public String salvar() {
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