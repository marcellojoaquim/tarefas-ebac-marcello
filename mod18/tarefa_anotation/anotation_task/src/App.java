import anotations.Computador;
import anotations.TabelaAnotation;

/*
 * Nesta abordagem eu já sei que á uma anotação e qual o tipo dela
 * porem caso ão saiba teria que usar Annotations para identificar.
 */
public class App {
    public static void main(String[] args) throws Exception {
        executaLeituraAnotacoes();

    }

     private static void executaLeituraAnotacoes(){

        System.out.println("Lendo anotacoes");
        Computador comp = new Computador();
        System.out.println();

        TabelaAnotation anot = comp.getClass().getAnnotation(TabelaAnotation.class);
        System.out.println(anot.value());
    }
}
