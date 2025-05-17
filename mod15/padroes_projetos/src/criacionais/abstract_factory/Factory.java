package criacionais.abstract_factory;

public abstract class Factory {
  
  public Car create(String requestGrade) {
    Car car = retrieveCar(requestGrade);
    return car;
  }

  private Car prepareCar(Car car){
    car.clean();
    car.mechanicCheck();
    car.fuelCar();
    return car;
  }

  protected abstract Car retrieveCar(String requestGrade);
}
