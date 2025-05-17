package criacionais.singleton;

public class SingletonSincronized {

  private static SingletonSincronized singleton;
  private String value;

  private SingletonSincronized(String value) {this.value = value;}

  public static synchronized SingletonSincronized getInstance(String value) {
    if (singleton == null) {
      singleton = new SingletonSincronized(value);
    }
    return singleton;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

}
