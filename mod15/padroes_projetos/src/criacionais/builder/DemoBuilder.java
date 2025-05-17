package criacionais.builder;

public class DemoBuilder {

  public static void main(String[] args) {
    Director director = new Director();
    director.setBuilder(new CheeseBurgerBuilder());
    Burger burger = director.buildBurger();
    System.out.println(burger.toString());

    director.setBuilder(new VeganBurgerBuilder());
    Burger burger2 = director.buildBurger();
    System.out.println(burger2.toString());
  }
}
