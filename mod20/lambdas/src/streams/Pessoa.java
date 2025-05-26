package streams;

import java.util.List;

public class Pessoa {
  private String id;
  private String nome;
  private String nacionalidade;
  private int idade;
  
  public Pessoa(String id, String nome, String nacionalidade, int idade) {
    this.id = id;
    this.nome = nome;
    this.nacionalidade = nacionalidade;
    this.idade = idade;
  }

  public Pessoa(Pessoa p){
    this(p.getId(), p.getNome(), p.getNacionalidade(), p.getIdade());
  }

  public Pessoa() {}

  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public String getNacionalidade() {
    return nacionalidade;
  }
  public void setNacionalidade(String nacionalidade) {
    this.nacionalidade = nacionalidade;
  }
  public int getIdade() {
    return idade;
  }
  public void setIdade(int idade) {
    this.idade = idade;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Pessoa other = (Pessoa) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Pessoa [id=" + id + ", nome=" + nome + ", nacionalidade=" + nacionalidade + ", idade=" + idade + "]";
  }
  

  public List<Pessoa> popularPessoa() {
    Pessoa p1 = new Pessoa("id1", "Pessoa Um", "Brasileiro", 43);
    Pessoa p2 = new Pessoa("id2", "Pessoa Dois", "Argentino", 30);
    Pessoa p3 = new Pessoa("id3", "Pessoa Tres", "Paraguaio", 19);
    Pessoa p4 = new Pessoa("id4", "Pessoa Quatro", "Brasileiro", 22);
    Pessoa p5 = new Pessoa("id5", "Pessoa Cinco", "Brasileiro", 20);
    Pessoa p6 = new Pessoa("id6", "Pessoa Seis", "Chileno", 26);
    Pessoa p7 = new Pessoa("id7", "Pessoa Sete", "Paraguaio", 27);
    Pessoa p8 = new Pessoa("id8", "Pessoa Oito", "Paraguaio", 28);
    Pessoa p9 = new Pessoa("id9", "Pessoa Nove", "Venezuelano", 39);
    Pessoa p10 = new Pessoa("id10", "Pessoa Dez", "Venezuelano", 31);
    Pessoa p11 = new Pessoa("id11", "Pessoa Onze", "Uruguaio", 41);
    Pessoa p12 = new Pessoa("id12", "Pessoa Doze", "Guiana Frencesa", 31);
    Pessoa p13 = new Pessoa("id13", "Pessoa Treze", "Brasileiro", 43);
    Pessoa p14 = new Pessoa("id14", "Pessoa Quatorze", "Colombiano", 43);
    Pessoa p15 = new Pessoa("id15", "Pessoa Quinze", "Colombiano", 48);
    return List.of(p9, p1, p2, p3, p10, p11, p12, p13,p15, p4, p5, p6, p7, p8, p14);
  }
}
