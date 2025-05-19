package observer;

public class BlogJornal implements Observer{

  @Override
  public void update(Subject subject) {
    System.out.println("Recebendo noticia online "+subject.toString());
  }

}
