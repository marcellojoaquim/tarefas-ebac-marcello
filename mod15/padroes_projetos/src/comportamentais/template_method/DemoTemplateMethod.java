package template_method;

public class DemoTemplateMethod {

  public static void main(String[] args) {
    Motorista moto = new Motorista();
    Carteiro cart = new Carteiro();

    moto.executaRotina();
    moto.finalizarRotina();

    cart.executaRotina();
    cart.finalizarRotina();
  }
}
