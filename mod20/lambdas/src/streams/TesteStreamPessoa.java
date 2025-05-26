package streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * Operacoes intermediárias
 * @author Marcello
 */
public class TesteStreamPessoa {
  public static void main(String[] args) {
    List<Pessoa> p = new Pessoa().popularPessoa();
    Stream<Pessoa> stream = p.stream().filter(pe -> pe.getNacionalidade().equals("Brasileiro"));
    System.out.println(stream.collect(Collectors.toList()).size());


    System.out.println("Lista de inteiros a partir de filtro de nacionalidade");

    Stream<Integer> stream2 = p.stream()
      .filter(p2 -> p2.getNacionalidade().equals("Paraguaio"))
      .map(Pessoa::getIdade);

    System.out.println(stream2.count());

    Stream<Pessoa> stream3 = p.stream()
      .filter(pessoa -> pessoa.getNacionalidade().equals("Brasileiro"))
      .sorted(Comparator.comparing(Pessoa::getNome));

    Stream<Pessoa> stream4 = p.stream()
      .filter(pessoa -> pessoa.getNacionalidade().equals("Brasileiro"))
      .sorted(Comparator.comparing(Pessoa::getIdade));

    Stream<Pessoa> stream5 = p.stream()
      .distinct().sorted(Comparator.comparing(Pessoa::getId));

    Stream<Pessoa> stream6 = p.stream()
      .distinct().limit(5);

    
    stream6.forEach(i->System.out.println(i));
  }
}
