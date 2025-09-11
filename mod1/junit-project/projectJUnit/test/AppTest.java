import org.junit.Assert;
import org.junit.Test;

public class AppTest {
  @Test
  public void testMain() {
    String name = "Teste";
    Assert.assertEquals("Teste", name);
  }

  @Test
  public void testNotEquals(){
    String name = "name";
    Assert.assertNotEquals("Name", name);
  }
}
