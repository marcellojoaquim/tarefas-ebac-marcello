package dao;

import domain.Cliente;
import exception.TipoChaveNaoEncontradaException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClienteDaoTest {
    private IClienteDao dao;
    private Cliente cliente;

    public ClienteDaoTest() {
        dao = new ClienteDaoMock();
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
        dao.cadastrar(cliente);
    }

    @Test
    public void salvar() throws TipoChaveNaoEncontradaException {
        Boolean result = dao.cadastrar(cliente);
        assertTrue(result);
    }

    @Test
    public void buscarPorCpf() {
        Cliente clienteConsultado = dao.consultar(cliente.getCpf());
        assertNotNull(clienteConsultado);
    }

    @Test
    public void excluirClient() {
        dao.excluir(cliente.getCpf());
    }

    @Test
    public void alterarClient() throws TipoChaveNaoEncontradaException {
        dao.alterar(cliente);
    }
}