package criacionais.builder.pessoa_builder.GoF.builder;

import criacionais.builder.pessoa_builder.GoF.PessoaModel;

public abstract class PessoaBuilder {

  protected PessoaModel pessoa;

  public PessoaBuilder() {
    pessoa = new PessoaModel();
  }

  public PessoaModel getPessoa() {
    return pessoa;
  }

  public abstract void buildNome();
  public abstract void buildCpf();
  public abstract void buildCnpj();
  public abstract void buildEndereco();
}
