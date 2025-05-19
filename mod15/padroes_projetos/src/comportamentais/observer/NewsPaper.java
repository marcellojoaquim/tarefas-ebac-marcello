package observer;

public class NewsPaper implements Observer{

  @Override
  public void update(Subject subject) {
    System.out.println("Recebendo noticias via jornal impresso "+subject.toString());
  }

}
