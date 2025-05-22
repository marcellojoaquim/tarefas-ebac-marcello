package anotations;

@TabelaAnotation(value = "tb_computadores")
public class Computador {

  @CamposAnotation(value = "comp_fabricante")
  private String fabricante;

}