package src;

public class App {
    public static void main(String[] args) throws Exception {
        int[] vetor = {1, 2, 3};
        Ventilador vent = new Ventilador();
        vent.setVelocidades(vetor);

        System.out.println(vent.getVelocidades(0));
    }
}
