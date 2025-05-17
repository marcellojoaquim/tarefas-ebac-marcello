package criacionais.builder;

public class VeganBurgerBuilder extends BurgerBuilder {

  @Override
  void buildBun() {
    burger.setBun("V Bread");
  }

  @Override
  void buildMeat() {
    burger.setMeat("V Beef");
  }

  @Override
  void buildSalad() {
    burger.setSalad("V Salad");
  }

  @Override
  void buildCheese() {
    burger.setCheese("V Cheese");
  }

  @Override
  void buildSauce() {
    burger.setSauce("V Sauce");
  }

}
