public class Moedas {

    private static final int[] MOEDAS = {5, 2, 1};
    private static int contCinco = 0, contDois = 0, contUm = 0;

    public static void contMoedas(int valor) {

        if(valor < 0){
            System.out.println("Valor invalido");
        }

        while(valor > 0){
            if(valor >= MOEDAS[0]){
                valor -= MOEDAS[0];
                contCinco++;
            }else if (valor >= MOEDAS[1]){
                valor -= MOEDAS[1];
                contDois++;
            }else{
                valor -= MOEDAS[2];
                contUm++;
            }
        }
    }
    public static void main(String[] args) {
        contMoedas(11);
        System.out.println("cindo: "+contCinco+" dois: "+contDois+" um: "+contUm);
    }
}