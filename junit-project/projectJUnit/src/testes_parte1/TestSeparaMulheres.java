package testes_parte1;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestSeparaMulheres {

  private List<String> aux = new ArrayList<>();
  private String palavras = "maria-f,marcos-m,joana-f,mariana-f,joao-m,jose-m,leopoldina-f";

  @Test
  public void testSuccess() {
    SeparaMulheres.incluiMulheres(palavras, aux);
    List<String> result = SeparaMulheres.separador(aux);

    Assert.assertTrue(!result.isEmpty());
    Assert.assertTrue(result.contains("leopoldina"));
    Assert.assertTrue(result.contains("maria"));
    Assert.assertEquals(4, result.size());
  }

  @Test
  public void testNotSuccess() {
    SeparaMulheres.incluiMulheres(palavras, aux);
    List<String> result = SeparaMulheres.separador(aux);

    Assert.assertFalse(result.isEmpty());
    Assert.assertTrue(!result.contains("marcos"));
    Assert.assertTrue(!result.contains("jose"));
    Assert.assertNotEquals(aux.size(), result.size());
  }

}
