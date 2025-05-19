package template_method;

public class Motorista extends Trabalhador{

  public void dirigir() {
    System.out.println("Dirigindo...");
  }

  @Override
  protected void trabalhar() {
    dirigir();
  }

}
