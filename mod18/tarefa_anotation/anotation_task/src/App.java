import anotations.CamposAnotation;
import anotations.TabelaAnotation;

public class App {
    public static void main(String[] args) throws Exception {
        

    }

    @TabelaAnotation(value = "tb_computadores")
    public class Computador {
        
        @CamposAnotation(value = "comp_fabricante")
        private String fabricante;
        
    }
}
