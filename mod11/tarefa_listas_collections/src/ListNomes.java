import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/**
 * Nesta classe recebemos uma string de nomes separados por vírgula
 * e realizamos o split e cada substring é adicionada a uma lista de strings
 * depois realizamos a ordenação com o método sort() da classe Collections
 * por fim imprimimos o resultado.
 */
public class ListNomes {
    public static void main(String[] args) throws Exception {
        List<String> nomes = new ArrayList<>();
        System.out.println("Digite os nomes");
        Scanner scanner = new Scanner(System.in);

        String texto = scanner.nextLine();

        for(String n : texto.split(",")) {
            nomes.add(n);
        }

        Collections.sort(nomes);
        System.out.println("Impressão da lista ordenada");
        System.out.println(nomes);

        scanner.close();
    }
}
