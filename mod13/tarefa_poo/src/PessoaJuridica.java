/**
 * @author Marcello
 * Classe que representa pessoa juridica e extende a classe abstrata Pessoa
 */
public class PessoaJuridica extends Pessoa{

  private String cnpj;


  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  @Override
  public String toString() {
    return "PessoaJuridica [cnpj=" + cnpj + ", getCnpj()=" + getCnpj() + ", getNome()=" + getNome() + ", getEndereco()="
        + getEndereco() + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
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
    PessoaJuridica other = (PessoaJuridica) obj;
    if (cnpj == null) {
      if (other.cnpj != null)
        return false;
    } else if (!cnpj.equals(other.cnpj))
      return false;
    return true;
  }

  
}
