/**
 * @author Marcello
 * Classe Endereço que é usada para pessoas fisicas e pessoas juridicas
 */
public class Endereco {

  private String logradouro;
  private String numero;
  private String bairro;
  private String cidade;
  private String estado;

  public Endereco(String logradouro, String numero, String bairro, String cidade, String estado) {
    this.logradouro = logradouro;
    this.numero = numero;
    this.bairro = bairro;
    this.cidade = cidade;
    this.estado = estado;
  }

  public Endereco(){}

  public String getLogradouro() {
    return logradouro;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
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
  public String toString() {
    return "Endereco [logradouro=" + logradouro + ", numero=" + numero + ", bairro=" + bairro + ", cidade=" + cidade
        + ", estado=" + estado + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((logradouro == null) ? 0 : logradouro.hashCode());
    result = prime * result + ((numero == null) ? 0 : numero.hashCode());
    result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
    result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
    result = prime * result + ((estado == null) ? 0 : estado.hashCode());
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
    Endereco other = (Endereco) obj;
    if (logradouro == null) {
      if (other.logradouro != null)
        return false;
    } else if (!logradouro.equals(other.logradouro))
      return false;
    if (numero == null) {
      if (other.numero != null)
        return false;
    } else if (!numero.equals(other.numero))
      return false;
    if (bairro == null) {
      if (other.bairro != null)
        return false;
    } else if (!bairro.equals(other.bairro))
      return false;
    if (cidade == null) {
      if (other.cidade != null)
        return false;
    } else if (!cidade.equals(other.cidade))
      return false;
    if (estado == null) {
      if (other.estado != null)
        return false;
    } else if (!estado.equals(other.estado))
      return false;
    return true;
  }

  
  
}
