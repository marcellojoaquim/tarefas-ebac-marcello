import fila.Fila;

public class TesteFila {

    public static void main(String[] args) {
        Fila fila = new Fila(10);
        fila.enqueue(10);
        fila.enqueue(11);
        fila.enqueue(12);
        fila.enqueue(13);
        fila.enqueue(14);

        System.out.println(fila.front());
        System.out.println(fila.rear());

        fila.dequeue();
        fila.dequeue();


        System.out.println(fila.front());
        System.out.println(fila.rear());

        //System.out.println(fila.toString());
    }
}
