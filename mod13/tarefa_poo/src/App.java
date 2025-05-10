public class App {
    public static void main(String[] args) throws Exception {
        Endereco enderecoPessoaFisica = new Endereco("Rua azul", "0101", "verde", "Longe demais", "Estado");
        Endereco enderecoPessoaJuridica = new Endereco("Rua verde", "1010", "azul", "Perto demais", "Estado A");
        PessoaFisica pessoa = new PessoaFisica();
        PessoaJuridica pessoaJ = new PessoaJuridica();

        pessoa.setNome("Pessoa fisica");
        pessoa.setCpf("1234567890");
        pessoa.setEndereco(enderecoPessoaFisica);

        pessoaJ.setNome("Lojinha da Esquina");
        pessoaJ.setCnpj("0987654321");
        pessoaJ.setEndereco(enderecoPessoaJuridica);

        System.out.println("Pessoa fisica");
        System.out.println(pessoa);

        System.out.println("Pessoa juridica");
        System.out.println(pessoaJ);
    }
}
