
import org.junit.Assert;
import org.junit.Test;

import dao.ContratoDao;
import dao.IContratoDao;
import dao.mocks.ContratoDaoMock;
import services.ContratoService;
import services.IContratoService;

public class ContratoServiceTest {

    @Test
    public void salvarTest() {
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }

    @Test()
    public void esperadoErroNoSalvarComBancoDeDadosTest() {
        IContratoDao dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }

    //TODO
    //Fazer métodos de buscar, excluir e atualizar

    @Test
  public void TestBuscar() {
      IContratoDao mockDao = new ContratoDao();
      IContratoService service = new ContratoService(mockDao);
      String retorno = service.buscar();
      Assert.assertEquals("Sucesso", retorno);
  }

  @Test
  public void TestExcluir() {
      IContratoDao mockDao = new ContratoDao();
      IContratoService service = new ContratoService(mockDao);
      boolean retorno = service.excluir();
      Assert.assertTrue(retorno);
  }

    @Test
  public void TestAtualizar() {
      IContratoDao mockDao = new ContratoDao();
      IContratoService service = new ContratoService(mockDao);
      String retorno = service.atualizar();
      Assert.assertEquals("Sucesso",retorno);
  }
}