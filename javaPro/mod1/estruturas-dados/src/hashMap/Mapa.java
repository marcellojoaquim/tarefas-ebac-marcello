package hashMap;

import java.util.ArrayList;
import java.util.List;

public class Mapa {

    private Dado[] dados;
    private int max, atual;

    public Mapa() {
        this.dados = new Dado[10];
        this.max = 10;
        this.atual = 0;
    }

    public void put(Dado dado) {
        if(atual == max){
            System.out.println("Mapa cheio");
            return;
        }
        var index = funcaoHash(dado.getChave());
        dados[index] = dado;
        atual++;
    }

    public void delete(Dado dado){
        var index = funcaoHash(dado.getChave());
        dados[index] = null;
    }

    public Dado get(int v) {
        var index = funcaoHash(v);
        return dados[index];
    }

    public void limpar() {
        dados = new Dado[10];
    }

    private int funcaoHash(int v) {
        var m = 11;
        return v % m;
    }
}
