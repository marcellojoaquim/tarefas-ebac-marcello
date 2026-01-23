import programacaoDinamica.FatorialTopDown;

public class Main {

    FatorialTopDown fibonacciDinamica = new FatorialTopDown();

    public static long fatorial_rec(int n) {
        if(n == 0){
            return 1;
        } else {
            return n * fatorial_rec(n-1);
        }
    }

    public static void main(String[] args) {
        int num = 7;
        long fatorialRec = fatorial_rec(num);
        System.out.println("Fatorial recursivo de "+ num  +" é: "+fatorialRec);

    }
}