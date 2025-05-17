package criacionais.singleton;

// Com sincrinized resolvemos o problema de thread safe do singleton
// porem compromete-se a performance do software uma vez que é criado uma fila de execução dos
// metodos e cada método aguarda a execução completa do anterior

public class TesteSingletonSincronizedThread {
   public static void main(String[] args) {
      Thread t1 = new Thread(new ThreadFoo());
      Thread t2 = new Thread(new ThreadBar());

      t1.start();
      t2.start();
  }

  static class ThreadFoo implements Runnable {

    @Override
    public void run() {
      SingletonSincronized singletonProperties = SingletonSincronized.getInstance("ThreadFoo - Sincronized");
      System.out.println(singletonProperties.getValue());
    }
  }

  static class  ThreadBar implements Runnable {

    @Override
    public void run() {
      SingletonSincronized singletonProperties = SingletonSincronized.getInstance("ThreadBar");
      System.out.println(singletonProperties.getValue());
    }
  }

}
