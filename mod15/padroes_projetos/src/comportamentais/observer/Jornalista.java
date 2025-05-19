package observer;

import java.util.ArrayList;
import java.util.List;

public class Jornalista implements Subject{

  private String titulo;

  public List<Observer> observers = new ArrayList<>();

  @Override
  public void registerObserver(Observer observer) {
    observers.add(observer);
  }

  @Override
  public void removeObserver(Observer observer) {
    observers.remove(observer);
  }

  @Override
  public void notifyObserver(String titulo) {
    this.titulo = titulo;
    for (Observer observer : observers) {
      observer.update(this);
    }
  }

  @Override
  public String toString() {
    return "Jornalista [titulo=" + titulo + "]";
  }

}
