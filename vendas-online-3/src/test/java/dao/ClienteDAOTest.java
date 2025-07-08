package dao;

import com.vendas.online.dao.ClienteDAO;
import com.vendas.online.domain.Cliente;
import com.vendas.online.exceptions.DAOException;
import com.vendas.online.exceptions.MaisDeUmRegistroException;
import com.vendas.online.exceptions.TableException;
import com.vendas.online.exceptions.TipoChaveNaoEncontradaException;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class ClienteDAOTest {

    @Test
    public void cadastrarCliente() throws DAOException, TipoChaveNaoEncontradaException {
        ClienteDAO dao = new ClienteDAO();
        Cliente cliente = new Cliente();
        cliente.setCpf(12345678900L);
        cliente.setNome("Cliente 01");
        cliente.setSobreNome("Sobrenome 01");
        cliente.setEnd("Endereco");
        cliente.setNumero(128);
        cliente.setCidade("Recife");
        cliente.setEstado("PE");
        cliente.setTel(98765432100L);

        boolean result = dao.cadastrar(cliente);
        assertTrue(result);

        dao.excluir(cliente.getCpf());
    }

    @Test
    public void consultarCliente() throws DAOException, TipoChaveNaoEncontradaException, TableException, MaisDeUmRegistroException {
        ClienteDAO dao = new ClienteDAO();
        Cliente cliente = new Cliente();
        cliente.setCpf(12345678900L);
        cliente.setNome("Cliente 01");
        cliente.setSobreNome("Sobrenome 01");
        cliente.setEnd("Endereco");
        cliente.setNumero(128);
        cliente.setCidade("Recife");
        cliente.setEstado("PE");
        cliente.setTel(98765432100L);

        dao.cadastrar(cliente);

        Cliente clienteSalvo = dao.consultar(cliente.getCpf());
        assertNotNull(clienteSalvo);
        assertEquals(cliente.getCpf(), clienteSalvo.getCpf());

        dao.excluir(clienteSalvo.getCpf());
    }

    @Test
    public void alterarCliente() throws DAOException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
        ClienteDAO dao = new ClienteDAO();
        Cliente cliente = new Cliente();
        cliente.setCpf(12345678900L);
        cliente.setNome("Cliente 01");
        cliente.setSobreNome("Sobrenome 01");
        cliente.setEnd("Endereco");
        cliente.setNumero(128);
        cliente.setCidade("Recife");
        cliente.setEstado("PE");
        cliente.setTel(98765432100L);

        dao.cadastrar(cliente);

        Cliente clienteSalvo = dao.consultar(cliente.getCpf());
        assertNotNull(clienteSalvo);

        clienteSalvo.setNome("Novo Nome");
        dao.alterar(clienteSalvo);

        Cliente clienteAlterado = dao.consultar(clienteSalvo.getCpf());
        assertNotNull(clienteAlterado);
        assertEquals("Novo Nome", clienteAlterado.getNome());

        dao.excluir(cliente.getCpf());
    }

    @Test
    public void buscarTodos() throws DAOException, TipoChaveNaoEncontradaException {
        ClienteDAO dao = new ClienteDAO();
        Cliente cliente = new Cliente();
        cliente.setCpf(12345678900L);
        cliente.setNome("Cliente 00");
        cliente.setSobreNome("Sobrenome 00");
        cliente.setEnd("Endereco");
        cliente.setNumero(128);
        cliente.setCidade("Recife");
        cliente.setEstado("PE");
        cliente.setTel(98765432100L);

        Cliente cliente1 = new Cliente();
        cliente1.setCpf(12345678901L);
        cliente1.setNome("Cliente 01");
        cliente.setSobreNome("Sobrenome 01");
        cliente1.setEnd("Endereco");
        cliente1.setNumero(256);
        cliente1.setCidade("Recife");
        cliente1.setEstado("PE");
        cliente1.setTel(98765432101L);

        Cliente cliente2 = new Cliente();
        cliente2.setCpf(12345678902L);
        cliente2.setNome("Cliente 02");
        cliente.setSobreNome("Sobrenome 02");
        cliente2.setEnd("Endereco");
        cliente2.setNumero(512);
        cliente2.setCidade("Recife");
        cliente2.setEstado("PE");
        cliente2.setTel(98765432102L);

        dao.cadastrar(cliente);
        dao.cadastrar(cliente1);
        dao.cadastrar(cliente2);

        Collection<Cliente> list = dao.buscarTodos();
        assertNotNull(list);

        list.forEach(cli -> {
            try {
                dao.excluir(cli.getCpf());
            } catch (DAOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}