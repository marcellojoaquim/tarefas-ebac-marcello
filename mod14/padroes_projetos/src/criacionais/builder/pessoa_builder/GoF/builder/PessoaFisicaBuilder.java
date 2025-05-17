package criacionais.builder.pessoa_builder.GoF.builder;

public class PessoaFisicaBuilder extends PessoaBuilder{

  @Override
  public void buildNome() {
    pessoa.setNome("Pessoa Fisica");
  }

  @Override
  public void buildCpf() {
    pessoa.setCpf(123l);
  }

  @Override
  public void buildCnpj() {
  }

  @Override
  public void buildEndereco() {
    pessoa.setEndereco("Endereco pessoa fisica");
  }

}
