import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
       int num1, num2, num3, num4, media;
       System.out.println("Digite as notas");
       Scanner scanner = new Scanner(System.in);

       num1 = scanner.nextInt();
       num2 = scanner.nextInt();
       num3 = scanner.nextInt();
       num4 = scanner.nextInt();

       Notas notas = new Notas(num1, num2, num3, num4);
       media = notas.calculaMedia();
       System.out.println("A media é: "+ media);
       scanner.close();
    }
}
