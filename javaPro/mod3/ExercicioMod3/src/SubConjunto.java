import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubConjunto {
    final static Integer[] CONJ = {1, 2, 3, 4};

    private static void combinar(
            int inicio, int n,
            List<Integer> temp,
            List<List<Integer>> result) {
        if (temp.size() == n) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = inicio; i < CONJ.length; i++) {
            temp.add(CONJ[i]);
            combinar(i + 1, n, temp, result);

            temp.remove(temp.size() - 1);
        }
    }

    public static void calculaSubConj(int n) {
        List<List<Integer>> resultado = new ArrayList<>();
        combinar(0, n, new ArrayList<>(), resultado);

        for (List<Integer> sub : resultado) {
            System.out.println(sub);
        }
    }

    public static void main(String[] args) {
        calculaSubConj(2);
    }


}
