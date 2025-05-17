package criacionais.builder;

public class Director {

  BurgerBuilder builder;

  public Burger buildBurger() {
    builder.buildBun();
    builder.buildMeat();
    builder.buildCheese();
    builder.buildSalad();
    builder.buildSauce();
    return builder.build();
  }



  public void setBuilder(BurgerBuilder builder) {
    this.builder = builder;
  }
}
