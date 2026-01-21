import pilha.Pilha;

public class TestePilha {

    public static void main(String[] args) {
        Pilha pilha = new Pilha(10);

        pilha.push(1);
        pilha.push(2);
        pilha.push(3);
        pilha.push(4);

        System.out.println(pilha.top());
        System.out.println();
        pilha.pop();
        pilha.pop();
        System.out.println(pilha.top());
        pilha.pop();
        System.out.println(pilha.size());
        pilha.pop();

        System.out.println(pilha.isEmpty());
    }
}
