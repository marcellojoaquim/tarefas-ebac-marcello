package fila;

import java.util.Arrays;

public class Fila {

    private int inicio, fim, tamFila, cap;
    private int[] elementos;

    public Fila(int cap){
        this.cap = cap;
        this.elementos = new int[cap];
        this.inicio = 0;
        this.fim = 0;
        this.tamFila = 0;
    }


    public void enqueue(int num) {
        if(tamFila == cap) {
            System.out.println("fila cheia");
            return;
        }
        elementos[fim] = num;
        fim = (fim + 1) % cap;
        tamFila++;
    }

    public void dequeue() {
            if(tamFila == 0){
                System.out.println("Fila vazia");
            }
            inicio = (inicio + 1) % cap;
            tamFila--;
    }

    public int rear() {
        return elementos[fim-1];
    }

    public int front() {
        return elementos[inicio];
    }

    public int size() {
        return tamFila;
    }

    public boolean isEmpty() {
        return tamFila == 0;
    }

}
