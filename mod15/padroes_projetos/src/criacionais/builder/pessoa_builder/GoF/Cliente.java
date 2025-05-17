package criacionais.builder.pessoa_builder.GoF;

import criacionais.builder.pessoa_builder.GoF.builder.PessoaBuilder;
import criacionais.builder.pessoa_builder.GoF.builder.PessoaFisicaBuilder;
import criacionais.builder.pessoa_builder.GoF.builder.PessoaJuridicaBuilder;
import criacionais.builder.pessoa_builder.GoF.director.PessoDirector;

public class Cliente {

  public static void criar(String tipo, PessoaBuilder builder) {
    System.out.println("Criando pessoa tipo: "+tipo);
    PessoDirector director = new PessoDirector(builder);
    director.constructPessoa();
    System.out.println(director.getPessoa());

    System.out.println("Fim da criação");
  }

  public static void main(String[] args) {
    criar("Pessoa fisica", new PessoaFisicaBuilder());
    criar("Pessoa juridica", new PessoaJuridicaBuilder());
  }
}
