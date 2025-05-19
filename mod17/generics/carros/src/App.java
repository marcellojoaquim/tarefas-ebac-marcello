import model.Carro;
import model.Honda;
import model.VW;
import servico.CadastraCarro;

public class App {
    public static void main(String[] args) {

        CadastraCarro<Carro> carros = new CadastraCarro<>();
        Honda car = new Honda("preto", 2020);
        VW carVW  = new VW("Azul", 2022);
        carros.cadastra(car);
        carros.cadastra(carVW);

        System.out.println(carros.toString());

    }
}
