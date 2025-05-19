package observer;

public class TV implements Observer{

  @Override
  public void update(Subject subject) {
    System.out.println("Recebendo noticias via TV "+subject.toString());
  }

}
