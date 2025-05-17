package criacionais.builder.pessoa_builder.GoF.builder;

public class PessoaJuridicaBuilder extends PessoaBuilder{

  @Override
  public void buildNome() {
    pessoa.setNome("Pessoa Juridica");
  }

  @Override
  public void buildCpf() {
  }

  @Override
  public void buildCnpj() {
    pessoa.setCnpj(321l);
  }

  @Override
  public void buildEndereco() {
    pessoa.setEndereco("Endereco pessoa juridica");
  }

}
