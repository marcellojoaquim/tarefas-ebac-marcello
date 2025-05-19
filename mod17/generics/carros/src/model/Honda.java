package model;

public class Honda implements Carro{
  
  private String cor;
  private Integer ano;

  

  public Honda(String cor, Integer ano) {
    this.cor = cor;
    this.ano = ano;
  }

  @Override
  public void ligar() {
    System.out.println("Ligando o carro");
  }

  @Override
  public void acelerar() {
        System.out.println("Acelerando o carro");

  }

  @Override
  public void desligar() {
        System.out.println("Desligando o carro");
  }

  @Override
  public String toString() {
    return "Fabricante Honda Cor "+cor+ "Ano" + ano;
  }

  public String getCor() {
    return cor;
  }

  public void setCor(String cor) {
    this.cor = cor;
  }

  public Integer getAno() {
    return ano;
  }

  public void setAno(Integer ano) {
    this.ano = ano;
  }

}
