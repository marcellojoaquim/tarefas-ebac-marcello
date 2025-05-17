package criacionais.builder.pessoa_builder.fluentAPI.builder;

import criacionais.builder.pessoa_builder.fluentAPI.PessoaModel;

public class PessoaBuilder {

  //Obrigatorio
  private String nome;

  //Opcionais
  private Long cpf;
  private Long cnpj;
  private String endereco;

  public PessoaBuilder(String nome) {
    this.nome = nome;
  }

  public PessoaBuilder andCpf(Long cpf){
    this.cpf = cpf;
    return this;
  }

  public PessoaBuilder andCnpj(Long cnpj) {
    this.cnpj = cnpj;
    return this;
  }

  public PessoaBuilder andEndereco(String endereco) {
    this.endereco = endereco;
    return this;
  }

  public PessoaModel contructPessoa() {
    return new PessoaModel(nome, cpf, cnpj, endereco);
  }
}
