package listaEncadeada;

public class Node {

    public int info;
    public Node next;

    public Node (int val) {
        info = val;
        next = null;
    }

    public Node (int val, Node next) {
        info = val;
        this.next = next;
    }


    public Node () {}

    @Override
    public String toString() {
        return "Node{" +
                "info=" + info +
                ", next=" + next +
                '}';
    }
}
