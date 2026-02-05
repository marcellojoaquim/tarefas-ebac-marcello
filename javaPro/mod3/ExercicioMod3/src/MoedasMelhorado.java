import java.util.LinkedHashMap;
import java.util.Map;

public class MoedasMelhorado {

    private static int[] MOEDAS = {5, 2, 1};

    public static Map<Integer, Integer> contaMoedas(int valor) {
        if(valor < 0) {
            throw new IllegalArgumentException("Valor inválido");
        }
        
        Map<Integer, Integer> resultado = new LinkedHashMap<>();
        
        for (int moeda: MOEDAS){
            if(valor >= moeda){
                int quantidade = valor / moeda;
                valor = valor % moeda;
                resultado.put(moeda, quantidade);
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        int valor = 18;
        Map<Integer, Integer> result = contaMoedas(valor);
        result.forEach((moeda, qtd) -> System.out.println("Moeda: "+ moeda+" qtd: "+qtd));
    }
}
