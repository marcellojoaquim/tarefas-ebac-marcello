import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Digite um numero");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println("Tipo primitivo: "+num);
        Integer number = num;
        System.out.println("Wrapper Integer: "+number);
        scanner.close();
    }
}
