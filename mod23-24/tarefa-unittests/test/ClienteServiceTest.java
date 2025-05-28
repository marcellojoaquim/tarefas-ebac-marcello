

import org.junit.Assert;
import org.junit.Test;

import dao.ClienteDao;
import dao.ClienteDaoMock;
import dao.IClienteDao;
import services.ClienteService;

public class ClienteServiceTest {

  @Test
  public void salvarTest() {
      IClienteDao mockDao = new ClienteDaoMock();
      ClienteService service = new ClienteService(mockDao);
      String retorno = service.salvar();
      Assert.assertEquals("Sucesso", retorno);
  }

  @Test()
  public void esperadoErroNoSalvarTest() {
      IClienteDao mockDao = new ClienteDao();
      ClienteService service = new ClienteService(mockDao);
      String retorno = service.salvar();
      Assert.assertEquals("Sucesso", retorno);
  }

  @Test
  public void TestBuscar() {
      IClienteDao mockDao = new ClienteDaoMock();
      ClienteService service = new ClienteService(mockDao);
      String retorno = service.buscar();
      Assert.assertEquals("Sucesso", retorno);
  }

  @Test
  public void TestExcluir() {
      IClienteDao mockDao = new ClienteDaoMock();
      ClienteService service = new ClienteService(mockDao);
      boolean retorno = service.excluir();
      Assert.assertTrue(retorno);
  }

    @Test
  public void TestAtualizar() {
      IClienteDao mockDao = new ClienteDaoMock();
      ClienteService service = new ClienteService(mockDao);
      String retorno = service.atualizar();
      Assert.assertEquals("Sucesso",retorno);
  }

}
