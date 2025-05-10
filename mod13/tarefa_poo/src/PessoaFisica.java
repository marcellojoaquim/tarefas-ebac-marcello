/**
 * @author Marcello
 * Classe que representa pessoa fisica e extende a classe abstrata Pessoa
 */
public class PessoaFisica extends Pessoa {

  private String cpf;

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  @Override
  public String toString() {
    return "PessoaFisica [cpf=" + cpf + ", getCpf()=" + getCpf() + ", getNome()=" + getNome() + ", getEndereco()="
        + getEndereco() + "]";
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
    PessoaFisica other = (PessoaFisica) obj;
    if (cpf == null) {
      if (other.cpf != null)
        return false;
    } else if (!cpf.equals(other.cpf))
      return false;
    return true;
  }

}
