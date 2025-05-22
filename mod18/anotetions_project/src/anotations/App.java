package anotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import anotations.MyAnotation;
import anotations.MyAnotationForField;
import reflections.Product;
public class App {

    @MyAnotationForField(value = "variavel tipo Number")
    private Number num;

    @MyAnotationForField(value = "String", maisInfo = "Novo valor")
    private String letras;

    public Number numbers() {
        return 10;
    }

    @MyAnotation(value = "Valor")
    public String myMethod() {
            return "";
    }

    private static void executaLeituraAnotacoes(){
        System.out.println("Lendo anotacoes");
        Product app = new Product();
        Annotation[] annotations = app.getClass().getAnnotations();
        System.out.println("Pegando o tipo de anotação: "+annotations.toString());
        for (Annotation annotation : annotations) {
            System.out.println("Annotations " + annotation.annotationType().toString());
        }

        System.out.println();
        System.out.println("varifica se há anotacao");

        for (Field field : app.getClass().getDeclaredFields()) {
            if(field.isAnnotationPresent(MyAnotationForField.class)){
                MyAnotationForField myAnotation = field.getAnnotation(MyAnotationForField.class);
                System.out.println(myAnotation);

            }
        }
    }

    public static void main(String[] args) throws Exception {
        executaLeituraAnotacoes();
    }
}
