package hashMap;

public class Dado {

    private int chave, valor;

    public Dado(int chave, int valor) {
        this.chave = chave;
        this.valor = valor;
    }

    public int getChave() {
        return chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Dado{" +
                "chave=" + chave +
                ", valor=" + valor +
                '}';
    }
}
