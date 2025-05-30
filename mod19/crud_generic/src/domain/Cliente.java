package domain;

import annotation.Chave;

public class Cliente implements Persistence{

  private String nome;

  @Chave("getCpf")
  private Long cpf;
  
  private Long tel;
  private String end;
  private Integer numero;
  private String cidade;
  private String estado;

  public Cliente(String nome, String cpf, String tel, String end, Integer numero, String cidade, String estado) {
    this.nome = nome;
    this.cpf = Long.valueOf(cpf.trim());
    this.tel = Long.valueOf(tel.trim());
    this.end = end;
    this.numero = numero;
    this.cidade = cidade;
    this.estado = estado;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Long getCpf() {
    return cpf;
  }

  public void setCpf(Long cpf) {
    this.cpf = cpf;
  }

  public Long getTel() {
    return tel;
  }

  public void setTel(Long tel) {
    this.tel = tel;
  }

  public String getEnd() {
    return end;
  }

  public void setEnd(String end) {
    this.end = end;
  }

  public Integer getNumero() {
    return numero;
  }

  public void setNumero(Integer numero) {
    this.numero = numero;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
    Cliente other = (Cliente) obj;
    if (cpf == null) {
      if (other.cpf != null)
        return false;
    } else if (!cpf.equals(other.cpf))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Cliente [nome=" + nome + ", cpf=" + cpf + ", tel=" + tel + ", end=" + end + ", numero=" + numero
        + ", cidade=" + cidade + ", estado=" + estado + "]";
  }

  @Override
  public Long getCodigo() {
    return this.cpf;
  }
  
  
}
