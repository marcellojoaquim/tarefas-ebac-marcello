package programacaoDinamica;

import java.math.BigInteger;
import java.util.Arrays;

public class FatorialTopDown {
    private static BigInteger[] numeros;

    public static BigInteger calcularFatorial(int n) {
        numeros = new BigInteger[n + 1];
        Arrays.fill(numeros, null);
        return fatorialAux(n);
    }

    private static BigInteger fatorialAux(int n) {
        if (n <= 1) {
            return BigInteger.ONE;
        }

        if (numeros[n] != null) {
            return numeros[n];
        }

        BigInteger resultado = BigInteger.valueOf(n).multiply(fatorialAux(n - 1));

        numeros[n] = resultado;
        return resultado;
    }

    public static void main(String[] args) {
        int n = 7;
        System.out.println("Fatorial de " + n + " é: " + calcularFatorial(n));
    }

}
