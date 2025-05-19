public class ClassGeneric <T> {
  private T data;

  public ClassGeneric(T data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "ClassGeneric [data=" + data + "]";
  }

  
}
