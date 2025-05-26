package streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestePessoaTerminal {
  
  public static void main(String[] args) {
    List<Pessoa> p = new Pessoa().popularPessoa();

    //p.stream().forEach(pe -> System.out.println(pe.getId()));

    //p.stream().forEach(pe -> System.out.println(pe.getNome().toUpperCase()));

    p.stream().filter(pe -> pe.getNacionalidade().equals("Brasileiro"))
      .map(Pessoa::getIdade)
      .forEach(pe -> System.out.println(pe));


    p.stream().filter(pe -> pe.getNacionalidade().equals("Brasileiro"))
      .map(Pessoa::getIdade)
      .forEachOrdered(pe -> System.out.println(pe));

    p.stream().filter(pe -> pe.getNacionalidade().startsWith("B"))
      .forEach(pe -> System.out.println(pe));

    p.stream().filter(pe -> pe.getId().toString().endsWith("3"))
      .forEach(pe -> System.out.println(pe));


    boolean result = p.stream().allMatch(pe -> pe.getNacionalidade().equals("Colombiano"));
    System.out.println(result);

    boolean result2 = p.stream().allMatch(pe -> pe.getIdade()>10);
    System.out.println(result2);

    List<Pessoa> newList = p.stream().filter(pessoa -> pessoa.getNacionalidade().equals("Chileno"))
      .collect(Collectors.toList());

    newList.forEach(System.out::println);

    p.stream().filter(pessoa -> pessoa.getNacionalidade().equals("Uruguaio"))
      .collect(Collectors.toList()).forEach(System.out::println);


    System.out.println("Pessoa uruguai ou paraguai");
    List<Pessoa> listB = p.stream()
      .filter(pessoa -> pessoa.getNacionalidade().equals("Uruguaio") || pessoa.getNacionalidade().equals("Paraguaio"))
      .collect(Collectors.toCollection(ArrayList::new));

    listB.forEach(System.out::println);
    System.out.println(listB.size());
    
    p.stream().filter(pessoa -> pessoa.getNacionalidade().equals("Uruguaio"))
      .collect(Collectors.toCollection(ArrayList::new)).forEach(System.out::println);


    Map<Integer, Pessoa> groupByIdade = p.stream().filter(pe -> pe.getNacionalidade()
      .equals("Argentino"))
      .collect(Collectors.toMap(Pessoa::getIdade, Pessoa::new));

    Map<Integer, List<Pessoa>> groupByIdade2 = p.stream().collect(Collectors.groupingBy(Pessoa::getIdade));
      groupByIdade2.forEach((k, v) -> System.out.println(k+" / "+v));

    Map<String, Integer> groupBySumIdade = p.stream().collect(Collectors
      .groupingBy(Pessoa::getNacionalidade,Collectors.summingInt(Pessoa::getIdade)));
    groupBySumIdade.forEach((k, v) -> System.out.println(k+" / "+v));  

    //optional
    System.out.println(" ");
    System.out.println("Optional");
    System.out.println(" ");
    optional();
  }

  private static void optional() {
    List<Pessoa> pessoas = new Pessoa().popularPessoa();

    Optional<Pessoa> maior = pessoas.stream().max(Comparator.comparing(Pessoa::getIdade));
    maior.ifPresent(System.out::println);

    //ou 

    if(maior.isPresent()){
      System.out.println(maior.get());
    }
  }

}
