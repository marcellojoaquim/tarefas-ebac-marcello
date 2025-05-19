package estrutural.facade;

public class ApartamentoService implements IApartamento{

  @Override
  public Boolean cadastrarApartamento(Apartamento apartamento) {
    isApartamentoCadastrado(true);
    isCamposValidos();
    System.out.println("Cadastrado com sucesso.");
    return true;
  }

  private Boolean isApartamentoCadastrado(Boolean bool){
    return bool;
  }

  public Boolean isCamposValidos() {
    return true;
  }
  public Boolean persist(){
    return true;
  }
}
