package listaEncadeada;

public class ListaEncadeada {

    public Node init, end;
    public int listaSize, maxSize;

    public ListaEncadeada(int v) {
        this.init = null;
        this.end = null;
        this.listaSize = 0;
        this.maxSize = v;
    }

    public int size() {
        return listaSize;
    }

    public void insert(int index, Node n) {

        if (index < size()){
            Node aux = init;
            for (int i =0; i < index; i++){
                aux = aux.next;
            }
            aux.info = n.info;

        } else {
            System.out.println("Indice invalido - insert");
        }
    }

    public void push(int v) {
        if (listaSize == 0){
            init = new Node(v);
            listaSize++;
        } else {
            Node aux = init;
            while (aux.next != null) {
                aux = aux.next;
            }
                Node newNode = new Node(v);
                aux.next = newNode;
                listaSize++;
        }
    }

    public Node pop() {
        if(size() != 0 ){
            Node v = end;
            Node aux = init;
            while (aux.next.next != null) {
                aux = aux.next;
            }
            aux.next = null;
            end = aux;
            listaSize--;
            return v;
        } else {
            return null;
        }
    }

    public Node elementAt(int index) {
        if(index < size()){
            Node aux = init;
            for (int i = 0; i < index; i++){
                aux = aux.next;
            }
            return new Node(aux.info);
        } else {
            return null;
        }
    }

    public void printLista() {
        Node aux = init;
        System.out.print("[ ");
        for (int i =0; i < size(); i++){
            System.out.print(aux.info + " ");
            aux = aux.next;
        }
        System.out.print(" ]");
    }

    public void remove(int index) {
        Node aux = init;
        listaSize--;
        if(index == 0){
            init = aux.next;
            init.next = aux.next.next;
        }else if(index <= size()){
            aux = init;
            for (int i = 0; i < index - 1; i++){
                aux = aux.next;
            }
            if(aux.next.next != null){
                aux.next = aux.next.next;
            }

        } else {
            System.out.println("index invalido- remove");
        }
    }

}
