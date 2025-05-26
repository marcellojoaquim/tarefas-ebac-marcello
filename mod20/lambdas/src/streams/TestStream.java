package streams;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class TestStream {
  public static void main(String[] args) {
    List<String> list = List.of("primeiro", "segundo", "terceiro");
    Stream<String> streamList = list.stream();
    
    Stream<String> set = Set.of("String1","String2","String3").stream();
    Map<String, String> map = Map.of("Marcello", "Silva");
    Stream<String> chaves= map.keySet().stream();
    Stream<String> valores = map.values().stream();
  }
}
