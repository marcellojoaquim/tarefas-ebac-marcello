package criacionais.singleton;

public class SingletonProperties {

  private static SingletonProperties singletonProperties;
  private String value;

  private SingletonProperties(String value) {this.value = value;}

  public static SingletonProperties getInstance(String value) {
    if (singletonProperties == null) {
      singletonProperties = new SingletonProperties(value);
    }
    return singletonProperties;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  
}
