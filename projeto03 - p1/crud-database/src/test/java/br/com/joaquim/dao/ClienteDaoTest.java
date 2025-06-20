package br.com.joaquim.dao;

import br.com.joaquim.dao.jdbc.ConnectionFactory;
import br.com.joaquim.domain.Cliente;
import static org.junit.Assert.*;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void buscarTodosTeste() throws SQLException {
        IClienteDao dao = new ClienteDao();
        Cliente cliente1 = new Cliente(1L, "cliente 1");
        Cliente cliente2 = new Cliente(2L, "cleinte 2");
        Cliente cliente3 = new Cliente(3L, "cliente 3");
        dao.cadastrar(cliente1);
        dao.cadastrar(cliente2);
        dao.cadastrar(cliente3);

        List<Cliente> clienteList = new ArrayList<>();
        clienteList = dao.buscarTodos();

        assertEquals(3, clienteList.size());
        assertNotNull(clienteList);

        for(Cliente c: clienteList){
            System.out.println("Tentando excluir produto com Código: " + c.getCodigo());
            dao.excluir(c);
        }
    }

    @Test
    public void closeConnectionTeste() throws SQLException {
        Connection conn = null;
        PreparedStatement statement = null;
        IClienteDao dao = new ClienteDao();
        try {
            conn = ConnectionFactory.getConnection();
            String sql = "SELECT id FROM tb_cliente WHERE id = 1";
            statement = conn.prepareStatement(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ((ClienteDao) dao).closeConnection(statement, conn);
        }

        assertTrue(conn.isClosed());
        assertTrue(statement.isClosed());
    }
}