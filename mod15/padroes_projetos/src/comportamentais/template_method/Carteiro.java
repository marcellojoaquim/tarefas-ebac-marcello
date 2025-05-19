package template_method;

public class Carteiro extends Trabalhador{

  @Override
  protected void trabalhar() {
    pegarRota();
    entregarCartas();
  }

  private void pegarRota() {
    System.out.println("Selecionar rota do dia.");
  }

  private void entregarCartas() {
   System.out.println("Entregar cartas...");
  }

}
