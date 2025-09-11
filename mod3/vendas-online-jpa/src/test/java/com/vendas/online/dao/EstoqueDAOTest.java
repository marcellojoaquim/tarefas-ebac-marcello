package com.vendas.online.dao;

import com.vendas.online.domain.Estoque;
import com.vendas.online.domain.Produto;
import com.vendas.online.exceptions.DAOException;
import com.vendas.online.exceptions.MaisDeUmRegistroException;
import com.vendas.online.exceptions.TableException;
import com.vendas.online.exceptions.TipoChaveNaoEncontradaException;
import static org.junit.Assert.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collection;

public class EstoqueDAOTest {

    @Test
    public void inserir() throws DAOException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
        ProdutoDAO dao = new ProdutoDAO();
        EstoqueDAO estoqueDAO = new EstoqueDAO();
        Produto produto = new Produto();
        produto.setNome("Produto 01");
        produto.setCodigo("prod-01");
        produto.setDescricao("descricao produto 01");
        produto.setFabricante("China");
        produto.setValor(new BigDecimal("128.256"));

        dao.cadastrar(produto);


        Estoque result = estoqueDAO.consultar(produto.getCodigo());
        assertNotNull(result);

        estoqueDAO.excluir(result);
        dao.excluir(produto);
    }

    @Test
    public void consultar() throws DAOException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
        ProdutoDAO dao = new ProdutoDAO();
        EstoqueDAO estoqueDAO = new EstoqueDAO();
        Produto produto = new Produto();
        produto.setNome("Produto 01");
        produto.setCodigo("prod-01");
        produto.setDescricao("descricao produto 01");
        produto.setFabricante("China");
        produto.setValor(new BigDecimal("128.256"));

        dao.cadastrar(produto);


        Estoque estoqueCadastrado = estoqueDAO.consultar(produto.getCodigo());

        assertNotNull(estoqueCadastrado);
        assertEquals(produto.getCodigo(), estoqueCadastrado.getCodigoProduto());


        estoqueDAO.excluir(estoqueCadastrado);
        dao.excluir(produto);
    }

    @Test
    public void atualizar() throws DAOException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
        ProdutoDAO dao = new ProdutoDAO();
        EstoqueDAO estoqueDAO = new EstoqueDAO();
        Produto produto = new Produto();
        produto.setNome("Produto 01");
        produto.setCodigo("prod-01");
        produto.setDescricao("descricao produto 01");
        produto.setFabricante("China");
        produto.setValor(new BigDecimal("128.256"));

        Produto produto1 = new Produto();
        produto1.setNome("Produto 02");
        produto1.setCodigo("prod-02");
        produto1.setDescricao("Descricao produto 02");
        produto1.setFabricante("Brazil");
        produto1.setValor(new BigDecimal("256.512"));

        dao.cadastrar(produto);
        dao.cadastrar(produto1);

        Estoque estoqueCadastrado = estoqueDAO.consultar(produto.getCodigo());

        estoqueCadastrado.setQuantidade(256);
        estoqueDAO.alterar(estoqueCadastrado);

        Estoque estoqueAlterado = estoqueDAO.consultar(estoqueCadastrado.getCodigoProduto().toString());

        assertEquals(produto.getCodigo(), estoqueAlterado.getCodigoProduto());
        assertEquals(256, (int)estoqueAlterado.getQuantidade());

        estoqueDAO.excluir(estoqueAlterado);
        dao.excluir(produto);
        dao.excluir(produto1);

    }

    @Test
    public void buscarTodos() throws DAOException, TipoChaveNaoEncontradaException {
        ProdutoDAO dao = new ProdutoDAO();
        EstoqueDAO estoqueDAO = new EstoqueDAO();
        Produto produto = new Produto();
        produto.setNome("Produto 01");
        produto.setCodigo("prod-01");
        produto.setDescricao("descricao produto 01");
        produto.setFabricante("China");
        produto.setValor(new BigDecimal("128.256"));

        Produto produto1 = new Produto();
        produto1.setNome("Produto 02");
        produto1.setCodigo("prod-02");
        produto1.setDescricao("Descricao produto 02");
        produto1.setFabricante("Brazil");
        produto1.setValor(new BigDecimal("256.512"));

        dao.cadastrar(produto);
        dao.cadastrar(produto1);


        Collection<Estoque> list = estoqueDAO.buscarTodos();
        assertNotNull(list);

        list.forEach(est -> {
            try {
                estoqueDAO.excluir(est);
                dao.excluir(est.getCodigoProduto());
            } catch (DAOException e) {
                throw new RuntimeException(e);
            }
        });
    }

}