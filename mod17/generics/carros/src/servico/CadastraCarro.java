package servico;

import java.util.ArrayList;
import java.util.List;

import model.Carro;

public class CadastraCarro<T extends Carro> implements ICadastraCarro<T>{

  private List<T> list;

  public CadastraCarro() { 
    this.list = new ArrayList<T>(); 
  }

  @Override
  public void cadastra(T t) {
    list.add(t);
  }

  public List<T> getList() {
    return list;
  }

  public void setList(List<T> list) {
    this.list = list;
  }

  @Override
  public String toString() {
    return "CadastraCarro [list=" + list + "]";
  }

}
