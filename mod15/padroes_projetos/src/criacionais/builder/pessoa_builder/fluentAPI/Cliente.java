package criacionais.builder.pessoa_builder.fluentAPI;

import criacionais.builder.pessoa_builder.fluentAPI.builder.PessoaBuilder;

public class Cliente {

  public static void main(String[] args) {

    PessoaModel pessoaFisica = new PessoaBuilder("Pessoa Fisica")
      .andCpf(123l)
      .andCnpj(null)
      .andEndereco("Endereco pessoa fisica")
      .contructPessoa();

      System.out.println(pessoaFisica);
      System.out.println("");


      PessoaModel pessoaJuridica = new PessoaBuilder("Pessoa Juridica")
        .andCpf(null)
        .andCnpj(321l)
        .andEndereco("Endereco pessoa juridica")
        .contructPessoa();
      
      System.out.println(pessoaJuridica);
  }
}
