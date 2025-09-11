package com.vendas.online.dao;

import com.vendas.online.domain.Produto;
import com.vendas.online.exceptions.DAOException;
import com.vendas.online.exceptions.MaisDeUmRegistroException;
import com.vendas.online.exceptions.TableException;
import com.vendas.online.exceptions.TipoChaveNaoEncontradaException;
import static org.junit.Assert.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collection;

public class ProdutoDAOTest {

    @Test
    public void cadastrar() throws DAOException, TipoChaveNaoEncontradaException {
        EstoqueDAO estoqueDAO = new EstoqueDAO();
        ProdutoDAO dao = new ProdutoDAO();
        Produto produto = new Produto();
        produto.setNome("Produto 01");
        produto.setCodigo("prod-01");
        produto.setDescricao("descricao produto 01");
        produto.setFabricante("China");
        produto.setValor(new BigDecimal(128.256));

        boolean result = dao.cadastrar(produto);
        assertTrue(result);

        dao.excluir(produto.getCodigo());
    }

    @Test
    public void buscar() throws DAOException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
        ProdutoDAO dao = new ProdutoDAO();
        Produto produto = new Produto();
        produto.setNome("Produto 01");
        produto.setCodigo("prod-01");
        produto.setDescricao("descricao produto 01");
        produto.setFabricante("China");
        produto.setValor(new BigDecimal(128.256));

        boolean result = dao.cadastrar(produto);
        assertTrue(result);

        Produto produtoSalvo = dao.consultar(produto.getCodigo());
        assertNotNull(produtoSalvo);
        assertEquals(produto.getNome(), produtoSalvo.getNome());
        assertEquals(produto.getDescricao(), produtoSalvo.getDescricao());

        dao.excluir(produto.getCodigo());
    }

    @Test
    public void atualizar() throws DAOException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
        ProdutoDAO dao = new ProdutoDAO();
        Produto produto = new Produto();
        produto.setNome("Produto 01");
        produto.setCodigo("prod-01");
        produto.setDescricao("descricao produto 01");
        produto.setFabricante("China");
        produto.setValor(new BigDecimal(128.256));

        dao.cadastrar(produto);

        Produto produtoSalvo = dao.consultar(produto.getCodigo());
        assertNotNull(produtoSalvo);

        produtoSalvo.setFabricante("Novo fabricante");
        dao.alterar(produtoSalvo);

        Produto produtoAlterado = dao.consultar(produtoSalvo.getCodigo());

        assertEquals(produtoSalvo.getNome(), produtoAlterado.getNome());
        assertEquals("Novo fabricante", produtoAlterado.getFabricante());

        dao.excluir(produtoAlterado.getCodigo());
    }

    @Test
    public void buscarTodos() throws DAOException, TipoChaveNaoEncontradaException {
        ProdutoDAO dao = new ProdutoDAO();
        Produto produto = new Produto();
        produto.setNome("Produto 01");
        produto.setCodigo("prod-01");
        produto.setDescricao("descricao produto 01");
        produto.setFabricante("China");
        produto.setValor(new BigDecimal(128.256));
        dao.cadastrar(produto);

        Produto produto2 = new Produto();
        produto2.setNome("Produto 02");
        produto2.setCodigo("prod-02");
        produto2.setDescricao("descricao produto 03");
        produto2.setFabricante("Brasil");
        produto2.setValor(new BigDecimal(256.512));
        dao.cadastrar(produto2);

        Produto produto3 = new Produto();
        produto3.setNome("Produto 03");
        produto3.setCodigo("prod-03");
        produto3.setDescricao("descricao produto 03");
        produto3.setFabricante("Paraguai");
        produto3.setValor(new BigDecimal(128.256));
        dao.cadastrar(produto3);

        Collection<Produto> list = dao.buscarTodos();

        assertNotNull(list);

        list.forEach(pro -> {
            try {
                dao.excluir(pro.getCodigo());
            } catch (DAOException e) {
                throw new RuntimeException(e);
            }
        });
    }

}