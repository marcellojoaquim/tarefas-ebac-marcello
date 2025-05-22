package reflections;

import anotations.MyAnotation;
import anotations.MyAnotationForField;

//@Deprecated
@MyAnotation("Product")
public class Product {

  @MyAnotationForField(value = "nome tipo String")
  private String nome;

  @MyAnotationForField(value = "codigo tipo Long")
  private Long codigo;

  @MyAnotationForField(value = "preco tipo Double")
  private Double preco;

  @MyAnotationForField(value = "taxa tipo Double")
  private Double taxa;

  public Product(String nome, Long codigo, Double taxa) {
    this.nome = nome;
    this.codigo = codigo;
    this.taxa = taxa;
  }

  public Product() {}

  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public Long getCodigo() {
    return codigo;
  }
  public void setCodigo(Long codigo) {
    this.codigo = codigo;
  }

  public Double getPreco() {
    return preco;
  }

  @MyAnotation("Metodo calcula preco")
  public void setPreco(Double preco) {
    this.preco = preco + this.taxa;
  }

  public Double getTaxa() {
    return taxa;
  }

  public void setTaxa(Double taxa) {
    this.taxa = taxa;
  }
}
