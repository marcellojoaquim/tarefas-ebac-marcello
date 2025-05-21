package exceptions;

public class MyException {

  public static void main(String[] args) throws MinhaCustomException {
    //comTratamentoException();
    //comTratamentoExceptionFinally();
    //omTratamentoRuntimeException();
    comTratamentoCustomException();

  }

  public static void comTratamentoException() {
    String str = null;
    String newStr = null;

    try {
      newStr = str.toLowerCase();
    } catch (NullPointerException e) {
      System.out.println("frase nula");
      str = "valor";
      newStr = str.toLowerCase();
    }

    System.out.println(newStr);
  }

  public static void comTratamentoExceptionFinally() {
    String str = null;
    String newStr = null;

    try {
      newStr = str.toLowerCase();
    } catch (NullPointerException e) {
      System.out.println("frase nula");
      str = "valor";
    } finally {
      newStr = str.toUpperCase();
    }

    System.out.println(newStr);
  }

  public static void comTratamentoRuntimeException() {
    String str = null;
    String newStr = null;

    try {
      newStr = str.toLowerCase();
    } catch (Exception e) {
      throw new RuntimeException("Parando execucao");
    }

    System.out.println("Continuando apos runtime exception");
  }

    public static String comTratamentoCustomException() throws MinhaCustomException {
    String str = null;
    String newStr = null;

    if(str == null || str == "") {
      throw new MinhaCustomException("Minha custom exception");
    }
      str = "Valor valido";
      newStr = str.toLowerCase();
      return newStr;
  }

}
