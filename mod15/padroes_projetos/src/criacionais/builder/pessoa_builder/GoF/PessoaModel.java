package criacionais.builder.pessoa_builder.GoF;

public class PessoaModel {

  private String nome;
  private Long cpf;
  private Long cnpj;
  private String endereco;

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
  public String getEndereco() {
    return endereco;
  }
  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }
  public Long getCnpj() {
    return cnpj;
  }
  public void setCnpj(Long cnpj) {
    this.cnpj = cnpj;
  }
  @Override
  public String toString() {
    return "PessoaModel [nome=" + nome + ", cpf=" + cpf + ", cnpj=" + cnpj + ", endereco=" + endereco + "]";
  }
}
