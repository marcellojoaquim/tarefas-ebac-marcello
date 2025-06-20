package br.com.joaquim.dao;

import br.com.joaquim.domain.Cliente;
import static org.junit.Assert.*;
import org.junit.Test;

import java.sql.SQLException;

public class ClienteDaoTest {

    @Test
    public void cadastrarClienteTeste() throws SQLException {
        IClienteDao dao = new ClienteDao();
        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Cliente 01");
        Integer qtd = dao.cadastrar(cliente);

        assertEquals(1, (int) qtd);
        dao.excluir(cliente);
    }

    @Test
    public void consultarClienteTeste() throws SQLException {
        IClienteDao dao = new ClienteDao();
        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Cliente 01");
        dao.cadastrar(cliente);

        Cliente clienteRecuperado = dao.consultar(cliente.getCodigo());
        assertNotNull(clienteRecuperado);
        assertNotNull(clienteRecuperado.getId());
        assertEquals(cliente.getCodigo(), clienteRecuperado.getCodigo());
        assertEquals(cliente.getNome(), clienteRecuperado.getNome());
    }

    @Test
    public void excluirClienteTests() throws SQLException {
        IClienteDao dao = new ClienteDao();
        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Cliente 01");
        dao.cadastrar(cliente);

        Integer result = dao.excluir(cliente);

        assertNotNull(result);
        assertTrue(result > 0);
    }

    @Test
    public void updateClienteTeste() throws SQLException {
        IClienteDao dao = new ClienteDao();
        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Cliente 01");
        dao.cadastrar(cliente);

        Cliente savedClient = dao.consultar(cliente.getCodigo());

        savedClient.setNome("Novo nome");
        Integer result = dao.atualizar(savedClient);

        assertTrue(result != 0);

        Cliente updatedClient = dao.consultar(cliente.getCodigo());

        assertEquals("Novo nome", updatedClient.getNome());
        dao.excluir(updatedClient);
    }
}