package functional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntFunction;

public class AnonimaClass {

  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
    List<String> listStrings = Arrays.asList("a", "b", "c", "d", "e", "f","g", "h");

    MyEventConsumer anonima = new MyEventConsumer() {
      @Override
      public void consumer(Object value) {
        System.out.println("Classe anonima.");
      }
    };

    anonima.consumer("Teste anonima");

    MyEventConsumer anonimaLambda = (Object value) -> {System.out.println(value);};
    anonimaLambda.consumer("Teste lambda");

    recebeInterface(anonimaLambda, "Metodo recebe interface");

    executaLambdaInt(list,"Vezes cinco", (n)->n*5);
    executaLambdaInt(list,"Vezes 10", (n)->n*10);
    executaLambdaInt(list,"Minus 10", (n)->n-10);
    executaLambdaStr(listStrings, "Palavras 1", (str)-> {});
  }

  private static void recebeInterface(MyEventConsumer anonimo, Object o) {
    anonimo.consumer(o);
  }

  private static void executaLambdaInt(List<Integer> list,String operation, IntFunction<Integer> function){
    System.out.println(operation);
    list.forEach(n -> {
      n = function.apply(n);
      System.out.print(n+" ");
      
    });
    System.out.println();
  }

  private static void executaLambdaStr(List<String> list, String operation, Consumer<String> function){
    System.out.println(operation);
    list.forEach(str -> {
      function.accept(str = str.toUpperCase());
      System.out.print(str+" ");
    });
    System.out.println();
  }
}
