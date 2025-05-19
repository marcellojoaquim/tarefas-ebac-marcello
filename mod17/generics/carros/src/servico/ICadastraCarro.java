package servico;

import model.Carro;

public interface ICadastraCarro<T extends Carro> {
  public void cadastra(T t);
}
