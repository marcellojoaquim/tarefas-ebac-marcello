import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Nesta classe é realizado a leitura de um texto contendo nomes e gêneros f ou m 
 * após a leitura é realizado o split para separar as substrings por nome ao mesmo tempo em que são classficadas onde há um HashMap contendo
 * a chave masculino e feminino, também há uma lista para cada gênero, quando um nome é lido e classificado ele é adicionado a lista a qual pertence.
 * Por fim tem-se duas listas uma para feminino outra para masculino dentro do HashMap pessoas.
 */
public class HashPessoas {
  public static void main(String[] args) {
    List<String> aux = new ArrayList<>();
    List<String> feminino = new ArrayList<>();
    List<String> masculino = new ArrayList<>();
    Map<String, List<String>> pessoas = new HashMap<>();

    System.out.println("Digite os nomes e seu genero separados por traço");

    Scanner scanner = new Scanner(System.in);
    String texto = scanner.nextLine();

    for (var s : texto.split(",")) {
      aux.add(s);
    }
    Collections.sort(aux);
    System.out.println("imprimindo aux");
    System.out.println(aux);

    for (var s : aux) {
      if(s.contains("-f") || s.contains("-f,")){
        var ss = s.split("-f")[0];
        ss.split("-f,");
        System.out.println(ss);
        feminino.add(ss);
        Collections.sort(feminino);
        pessoas.put("feminino", feminino);
      } else if(s.contains("-m") || s.contains("-m,")){
        var ss = s.split("-m")[0];
        ss.split("-m,");
        masculino.add(ss);
        Collections.sort(masculino);
        pessoas.put("maculino", masculino);
      }
    }
    System.out.println("Imprimindo pessoas");
    System.out.println(pessoas);
    scanner.close();
  }
}
