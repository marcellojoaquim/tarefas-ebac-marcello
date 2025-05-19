package observer;

public class DemoObserver {
  public static void main(String[] args) {
    Jornalista jour = new Jornalista();
    jour.registerObserver(new TV());
    jour.registerObserver(new NewsPaper());
    jour.notifyObserver("Teste");
  }
}
