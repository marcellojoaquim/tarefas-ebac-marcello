package estrutural.facade;

public class DemoFacade {
  public static void main(String[] args) {
    IApartamento service = new ApartamentoService();
    service.cadastrarApartamento(new Apartamento(123l, "rua sem saida"));
  }
}
