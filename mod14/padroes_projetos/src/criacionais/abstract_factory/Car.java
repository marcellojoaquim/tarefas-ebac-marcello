package criacionais.abstract_factory;

public abstract class Car {

  private int horsePower;
  private String fuelSource;
  private String color;

  

  public Car(int horsePower, String fuelSource, String color) {
    this.horsePower = horsePower;
    this.fuelSource = fuelSource;
    this.color = color;
  }

  protected void clean() {
    System.out.println( " Clean");
  }

  protected void mechanicCheck() {
    System.out.println("Mechanic Check");
  }

  protected void fuelCar() {
    System.out.println( "Fuel car");
  }

  public void startEngine() {
    System.out.println(getClass().getSimpleName());
    System.out.println("The "+fuelSource+"engine has been started");
  }

}
