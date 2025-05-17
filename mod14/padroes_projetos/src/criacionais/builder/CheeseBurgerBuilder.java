package criacionais.builder;

public class CheeseBurgerBuilder  extends BurgerBuilder{

  @Override
  void buildBun() {
    burger.setBun("Bread");
  }

  @Override
  void buildMeat() {
    burger.setMeat("Beef");
  }

  @Override
  void buildSalad() {
    burger.setSalad("Salad");
  }

  @Override
  void buildCheese() {
    burger.setCheese("Cheese");
  }

  @Override
  void buildSauce() {
    burger.setSauce("Sauce");
  }

}
