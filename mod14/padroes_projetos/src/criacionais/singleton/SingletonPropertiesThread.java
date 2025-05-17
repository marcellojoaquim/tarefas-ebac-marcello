package criacionais.singleton;

public class SingletonPropertiesThread {

  //este exemplo não ganrante as propriedade singleton.
  //significa que não é thread safe
  public static void main(String[] args) {
      Thread t1 = new Thread(new ThreadFoo());
      Thread t2 = new Thread(new ThreadBar());

      t1.start();
      t2.start();
  }

  static class ThreadFoo implements Runnable {

    @Override
    public void run() {
      SingletonProperties singletonProperties = SingletonProperties.getInstance("ThreadFoo");
      System.out.println(singletonProperties.getValue());
    }
  }

  static class  ThreadBar implements Runnable {

    @Override
    public void run() {
      SingletonProperties singletonProperties = SingletonProperties.getInstance("ThreadBar");
      System.out.println(singletonProperties.getValue());
    }
  }

}
