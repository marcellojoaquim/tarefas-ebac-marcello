package criacionais.abstract_factory;

public class SemContratosFactory extends Factory{

  @Override
  protected Car retrieveCar(String requestGrade) {
    if("B".equals(requestGrade)){
      return new BrasiliaCar(50, "Cheio", "Branco");
    } else {
      return new FuscaCar(45, "Cheio", "Preto");
    }
  }

}
