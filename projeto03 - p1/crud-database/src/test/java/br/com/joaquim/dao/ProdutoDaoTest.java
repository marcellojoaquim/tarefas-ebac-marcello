package br.com.joaquim.dao;

import br.com.joaquim.domain.Produto;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProdutoDaoTest {

    @Test
    public void cadastrar() throws SQLException {
        Produto produto = new Produto("produto 01", "codigo 01", "Descricao produto 01");
        IProdutoDAO dao = new ProdutoDao();

        Integer result = dao.cadastrar(produto);
        assertTrue(result != 0);

        dao.excluir(produto);
    }

    @Test
    public void consultar() throws SQLException {
        Produto produto = new Produto("produto 01", "codigo 01", "Descricao produto 01");
        IProdutoDAO dao = new ProdutoDao();
        dao.cadastrar(produto);

        Produto savedProduct = dao.consultar(produto.getCodigo());

        assertEquals(produto.getCodigo(), savedProduct.getCodigo());
        assertEquals(produto.getNome(), savedProduct.getNome());
        dao.excluir(produto);
    }

    @Test
    public void excluir() throws SQLException {
        Produto produto = new Produto("produto 01", "codigo 01", "Descricao produto 01");
        IProdutoDAO dao = new ProdutoDao();
        dao.cadastrar(produto);

        Integer result = dao.excluir(produto);
        assertTrue(result != 0);
        assertNotNull(result);
        Produto prod= dao.consultar(produto.getCodigo());
        assertNull(prod.getId());
    }

    @Test
    public void atualizar() throws SQLException {
        Produto produto = new Produto("Produto 01", "cod-prod", "descricao produto");
        IProdutoDAO dao = new ProdutoDao();
        dao.cadastrar(produto);

        Produto savedProduto = dao.consultar(produto.getCodigo());
        savedProduto.setNome("Novo nome");
        Integer result = dao.atualizar(savedProduto);

        assertTrue(result > 0);

        Produto updatedProduto = dao.consultar(savedProduto.getCodigo());
        assertEquals("Novo nome", updatedProduto.getNome());

        dao.excluir(updatedProduto);
    }

    @Test
    public void buscarTodos() throws SQLException {
        IProdutoDAO dao = new ProdutoDao();
        List<Produto> produtoList = new ArrayList<>();
        Produto produto = new Produto("Produto 01", "cod-prod", "descricao produto");
        Produto produto2 = new Produto("Produto 02", "cod-prod2", "descricao produto2");
        Produto produto3 = new Produto("Produto 03", "cod-prod3", "descricao produto 3");
        dao.cadastrar(produto);
        dao.cadastrar(produto2);
        dao.cadastrar(produto3);

        produtoList = dao.buscarTodos();

        assertEquals(3, produtoList.size());

        for (Produto prod: produtoList) {
            System.out.println("Tentando excluir produto com Código: " + prod.getCodigo());
            dao.excluir(prod);
        }
    }
}