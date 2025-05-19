public class GenericDemoClass {
  public static void main(String[] args) {
    String data = "Dados genéricos";
    Integer num = 123;
    ClassGeneric genericString = new ClassGeneric<String>(data);
    ClassGeneric genericInt = new ClassGeneric<Integer>(num);

    System.out.println(genericString.toString());
    System.out.println(genericInt.toString());
  }
}
