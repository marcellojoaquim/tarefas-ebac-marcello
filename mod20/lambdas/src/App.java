import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;

public class App {
    public static void main(String[] args) throws Exception {
        IntBinaryOperator operator = (int a, int b) -> {
            return a+b;
        };

        operator.applyAsInt(12, 23);

        BiFunction<String, String, String> biFunction = (String a, String b) -> {
            var palavra = a+" "+b;
            return palavra;
        };

        BiFunction<Integer, Integer, String> biFunctionStr = (Integer a, Integer b) -> {
            return String.valueOf(a+b);
        };

        var newString = biFunction.apply("Nova", "Palavra");
        System.out.println(newString);

        var integerToString = biFunctionStr.apply(10, 11);
        System.out.println(integerToString);

        var result = calculaLambda(12, 13, (Integer v1, Integer v2) -> {
            return v1+v2;
        });

        System.out.println(result);
    }

    private static Integer calculaLambda(Integer a, Integer b, BiFunction<Integer, Integer, Integer> function) {
        return function.apply(a, b);
    }
}
