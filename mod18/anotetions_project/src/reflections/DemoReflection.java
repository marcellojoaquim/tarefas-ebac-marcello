package reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import anotations.MyAnotationForField;

public class DemoReflection {

  public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, IllegalArgumentException, InstantiationException {
    //executeFields();
    //executeMethods();
    executaLeituraAnotacoes();
    //executaMetodosReflex();
  }

  public static void executeFields() {
    System.out.println("Propriedades");
    Product product = new Product();
    Field[] fields = product.getClass().getDeclaredFields();

    for (Field field : fields) {
      System.out.println(field);
      System.out.println(field.getName());
      System.out.println(field.getType());
      System.out.println();
    }
  }

  public static void executeMethods() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    System.out.println("Métodos");
    Product product = new Product();
    Method[] methods = product.getClass().getDeclaredMethods();
    for (Method method : methods) {
      System.out.println(method);
      System.out.println(method.getName());
      System.out.println(method.getReturnType());
      System.out.println("");
    }
  }

  private static void executaLeituraAnotacoes(){
        System.out.println("Lendo anotacoes");
        Product app = new Product();
        Annotation[] annotations = app.getClass().getAnnotations();
        System.out.println("Pegando o tipo de anotação: ");
        for (Annotation annotation : annotations) {
            System.out.println("Annotations " + annotation.annotationType());
            System.out.println("Annotations " + annotation);
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

    private static void executaMetodosReflex() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException{
      Product prod = new Product("TV", 10l, 10.0);
      Method[] methods = prod.getClass().getDeclaredMethods();
      for (Method m : methods) {
        if (m.getName().startsWith("get")) {
          System.out.println(m.invoke(prod));
        }
      }
    }

}
