package domain;

import static org.junit.Assert.*;

import dao.ClienteDaoMock;
import dao.IClienteDao;
import exception.TipoChaveNaoEncontradaException;
import org.junit.Before;
import org.junit.Test;
import services.ClienteService;
import services.IClienteService;

public class ClienteTest {
    private final IClienteService clienteService;
    private Cliente cliente;

    public ClienteTest() {
        IClienteDao dao = new ClienteDaoMock();
        clienteService = new ClienteService(dao);
    }

    @Before
    public void setup() throws TipoChaveNaoEncontradaException {
        cliente = new Cliente(
                "Cliente",
                12312312312L,
                9999999999L,
                "Rua sem saida",
                12,
                "Jaboatao dos Guararapes",
                "Estado");
    }

    @Test
    public void pesquisarCliente() {
        Cliente result = clienteService.buscarPorCPF(cliente.getCpf());

        assertNotNull(result);
        assertEquals(cliente.getCpf(), result.getCpf());
    }

    @Test
    public void savarTeste() throws TipoChaveNaoEncontradaException {
        Boolean result = clienteService.cadastrar(cliente);
        assertTrue(result);
    }

    @Test
    public void excluirClient() {
        clienteService.excluir(cliente.getCpf());
    }

    @Test
    public void alterarClient() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Novo nome");
        clienteService.alterar(cliente);

        assertEquals("Novo nome", cliente.getNome());
    }
}