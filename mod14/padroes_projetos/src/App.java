import criacionais.singleton.Singleton;
import criacionais.singleton.SingletonProperties;

public class App {
    public static void main(String[] args) throws Exception {

        // Demo singleton
        Singleton singleton = Singleton.getInstance();

        Singleton singleton2 = Singleton.getInstance();

        // Deve retornar um erro, construtor não visivel
        //Singleton singleton3 = new Singleton();

        System.out.println("Singleton");
        System.out.println(singleton);

        System.out.println("Singleton2");
        System.out.println(singleton2);


        SingletonProperties singletonProperties = SingletonProperties.getInstance("Primeira instacia");
        SingletonProperties singletonProperties2 = SingletonProperties.getInstance("Segunda instacia");

        System.out.println("Primeira instancia "+singletonProperties.getValue());
        System.out.println("Segunda instancia "+singletonProperties2.getValue());
    }
}
