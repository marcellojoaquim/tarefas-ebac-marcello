import listaEncadeada.ListaEncadeada;
import listaEncadeada.Node;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TesteLista {
    public static void main(String[] args) {
        Node node = new Node(55);
        ListaEncadeada listaEncadeada = new ListaEncadeada(10);

        listaEncadeada.push(12);
        listaEncadeada.push(13);
        listaEncadeada.push(14);
        listaEncadeada.push(15);
        listaEncadeada.push(16);
        listaEncadeada.push(17);
        listaEncadeada.push(18);
        listaEncadeada.push(19);
        listaEncadeada.push(20);
        listaEncadeada.push(21);

        System.out.println("Impressao da lista inicial");
        listaEncadeada.printLista();
        System.out.println();

        System.out.println("busca de elemento com index");
        Node node1 = listaEncadeada.elementAt(0);
        System.out.println(node1);
        System.out.println();

        listaEncadeada.remove(9);
        System.out.println("lista com remocao");
        listaEncadeada.printLista();
        System.out.println();

        System.out.println("Lista com adicao");
        listaEncadeada.insert(4, node);
        listaEncadeada.printLista();

        System.out.println();
        System.out.println("Lista pop");
        System.out.println(listaEncadeada.pop());
        listaEncadeada.printLista();

        System.out.println();
        System.out.println("Tamanho da Lista");
        System.out.println(listaEncadeada.size());


    }
}