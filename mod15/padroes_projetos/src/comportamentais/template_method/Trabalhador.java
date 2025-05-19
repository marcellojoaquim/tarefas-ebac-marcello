package template_method;
public abstract class Trabalhador {
  
  public void executaRotina() {
    iniciarRotina();
    levantar();
    trabalhar();
  }

  public void finalizarRotina() {
    voltar();
  }

  protected abstract void trabalhar();

  protected void iniciarRotina() {
    System.out.println("Iniciando rotina.");
  }

  private void levantar() {
    System.out.println("Ir p o trabalho");
  }

  private void voltar() {
    System.out.println("Voltar para casa");
  }
}
