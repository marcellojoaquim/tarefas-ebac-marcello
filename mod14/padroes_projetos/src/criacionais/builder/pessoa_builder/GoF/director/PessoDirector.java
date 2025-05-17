package criacionais.builder.pessoa_builder.GoF.director;

import criacionais.builder.pessoa_builder.GoF.PessoaModel;
import criacionais.builder.pessoa_builder.GoF.builder.PessoaBuilder;

public class PessoDirector {

  private PessoaBuilder builder;

  public PessoDirector(PessoaBuilder builder) {
    this.builder = builder;
  }

  public void constructPessoa() {
    builder.buildNome();
    builder.buildCpf();
    builder.buildCnpj();
    builder.buildEndereco();
  }

  public PessoaModel getPessoa() {
    return builder.getPessoa();
  }
}
