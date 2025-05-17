package criacionais.abstract_factory;

public class DemoFactory {
  public static void main(String[] args) {
    Customer cliente = new Customer("B", false);
    Factory factory = getFactory(cliente);
    Car car = factory.create(cliente.getGradeRequest());
    car.startEngine();
  }

  private static Factory getFactory(Customer cliente) {
    if(cliente.hasCompanyContract()) {
      return new ContratosFactory();
    } else {
      return new SemContratosFactory();
    }
  }
}
