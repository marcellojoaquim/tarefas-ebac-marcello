import org.junit.Assert;
import org.junit.Test;

public class SegundosTestes {

  @Test
  public void doisEqualstwo() {
    int num = 2;

    Assert.assertEquals(2, num);
  }

  @Test
  public void doisNotEqualsThree() {
    int num = 3;

    Assert.assertNotEquals(2, num);    
  }
}
