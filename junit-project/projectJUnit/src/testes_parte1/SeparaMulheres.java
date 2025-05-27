package testes_parte1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SeparaMulheres {

  public static void main(String[] args) {
    List<String> aux = new ArrayList<>();;

    System.out.println("Digite os nomes e seu genero separados por traço");

    Scanner scanner = new Scanner(System.in);
    String texto = scanner.nextLine();

    incluiMulheres(texto, aux);

    List<String> soMulheres = separador(aux);

    soMulheres.forEach(m -> System.out.println(m));

    scanner.close();
  }

  public static void incluiMulheres(String texto, List<String> aux){
    
    for (var s : texto.split(",")) {
      aux.add(s);
    }
  }

  public static List<String> separador(List<String> aux){

    List<String> mulheres = aux.stream().sorted()
      .filter(m -> m.contains("-f") || m.contains("-f,"))
      .map(m -> {String cleanName = m.replace("-f", "").replace("-f,", ""); return cleanName;})
      .collect(Collectors.toList());

    return mulheres;
  }

}
