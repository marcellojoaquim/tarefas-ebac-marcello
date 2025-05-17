package criacionais.abstract_factory;

public class ContratosFactory extends Factory{

  @Override
  protected Car retrieveCar(String requestGrade) {
    if("A".equals(requestGrade)) {
      return new CorolaCar(100, "Cheio", "Azul");
    } else {
      return new AudiCar(150, "Cheio", "Preto");
    }
  }
}
