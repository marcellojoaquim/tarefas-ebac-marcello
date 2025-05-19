import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
       List lista = new ArrayList<>();
       List<Long> listaLong = new ArrayList<>();
       lista.add("Marcello");
       lista.add(1);
       listaLong.add(1l);
       listaLong.add(2l);
       imprimirGeneric(listaLong);
       imprimir(lista);
    }

    private static void imprimir(List lista) {
        for (Object object : lista) {
            System.out.println(object);
        }
    }

    private static <T> void imprimirGeneric(List<T> list) {
        for (T t : list) {
            System.out.println(t);            
        }
    }
}
