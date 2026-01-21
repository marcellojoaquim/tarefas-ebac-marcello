package pilha;

public class Pilha {
    private int[] valor;
    private int livre, max, topo;

    public  Pilha(int max) {
        this.max = max;
        valor = new int[max];
        livre = 0;
    }

    public Pilha() {
        this.max = 100;
        valor = new int[max];
        livre = 0;
    }

    public void push(int v) {
        if (livre < max){
            valor[livre] = v;
            topo = livre;
            livre++;
        } else {
            System.out.println("Pilha completa");
        }
    }

    public int top() {
        if(livre > 0){
            return valor[topo];
        } else {
            return -1;
        }
    }

    public int pop() {
        if(livre > 0){
            var aux = livre -1;
            topo--;
            livre--;
            return valor[aux];
        } else {
            return -1;
        }
    }

    public boolean isEmpty() {
        if(livre > 0) {
            return false;
        } else {
            return true;
        }
    }

    public int size() {
        return topo+1;
    }
}
