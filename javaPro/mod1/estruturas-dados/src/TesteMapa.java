import hashMap.Dado;
import hashMap.Mapa;

public class TesteMapa {

    public static void main(String[] args) {
        Mapa mapa = new Mapa();

        Dado dado = new Dado(3, 101);
        Dado dado1 = new Dado(1, 110);
        Dado dado2 = new Dado(5, 110);
        Dado dado3 = new Dado(8, 111);
        Dado dado4 = new Dado(7, 11);
        Dado dado5 = new Dado(2, 112);
        Dado dado6 = new Dado(4, 140);
        Dado dado7 = new Dado(6, 110);
        Dado dado8 = new Dado(9, 110);

        mapa.put(dado);
        mapa.put(dado1);
        mapa.put(dado2);
        mapa.put(dado3);
        mapa.put(dado4);
        mapa.put(dado5);
        mapa.put(dado6);
        mapa.put(dado7);
        mapa.put(dado8);

        System.out.println(mapa.get(8).toString());
    }
}
