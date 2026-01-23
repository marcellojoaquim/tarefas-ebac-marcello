package programacaoDinamica;

import java.math.BigInteger;

public class FatorialBottomUp {

    public static BigInteger calcularFatorial(int n) {

        BigInteger[] tabela = new BigInteger[n + 1];

        tabela[0] = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            tabela[i] = BigInteger.valueOf(i).multiply(tabela[i - 1]);
        }

        return tabela[n];
    }

    public static void main(String[] args) {
        int n = 7;
        System.out.println("Fatorial de " + n + " é " + calcularFatorial(n));
    }
}
