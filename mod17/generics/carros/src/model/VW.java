package model;

public class VW implements Carro{

  private String cor;
  private Integer ano;
  
  public VW(String cor, Integer ano) {
    this.cor = cor;
    this.ano = ano;
  }

  @Override
  public void ligar() {
    System.out.println("Ligando o carro");
  }

  @Override
  public void acelerar() {
    System.out.println("acelerando o carro");
    
  }

  @Override
  public void desligar() {
    System.out.println("Desligando o carro");
    
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

  @Override
  public String toString() {
    return "Fabricante VW Cor "+cor+ "Ano" + ano;
  }
  

}
