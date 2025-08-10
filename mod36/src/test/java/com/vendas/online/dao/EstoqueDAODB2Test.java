package com.vendas.online.dao;

import com.vendas.online.domain.Estoque;
import com.vendas.online.domain.Produto;
import com.vendas.online.exceptions.DAOException;
import com.vendas.online.exceptions.MaisDeUmRegistroException;
import com.vendas.online.exceptions.TableException;
import com.vendas.online.exceptions.TipoChaveNaoEncontradaException;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EstoqueDAODB2Test {

    @Test
    public void inserir() throws DAOException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
        ProdutoDAODB2 dao = new ProdutoDAODB2();
        EstoqueDAODB2 estoqueDAODB1 = new EstoqueDAODB2();
        Produto produto = new Produto();
        produto.setNome("Produto 01");
        produto.setCodigo("prod-01");
        produto.setDescricao("descricao produto 01");
        produto.setFabricante("China");
        produto.setValor(new BigDecimal("128.256"));
        dao.cadastrar(produto);

        Estoque estoque = new Estoque();
        estoque.setCodigoProduto(produto);
        estoque.setQuantidade(128);

        var result = estoqueDAODB1.cadastrar(estoque);

        assertNotNull(result);

        estoqueDAODB1.excluir(result);

    }

    @Test
    public void consultar() throws DAOException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
        ProdutoDAODB2 dao = new ProdutoDAODB2();
        EstoqueDAODB2 estoqueDAODB1 = new EstoqueDAODB2();
        Produto produto = new Produto();
        produto.setNome("Produto 01");
        produto.setCodigo("prod-01");
        produto.setDescricao("descricao produto 01");
        produto.setFabricante("China");
        produto.setValor(new BigDecimal("128.256"));

        dao.cadastrar(produto);

        Estoque estoque = new Estoque();
        estoque.setCodigoProduto(produto);
        estoque.setQuantidade(128);

        var result = estoqueDAODB1.cadastrar(estoque);

        Estoque estoqueCadastrado = estoqueDAODB1.consultar(result.getId().toString());

        assertNotNull(estoqueCadastrado);
        assertEquals(produto.getId(), estoqueCadastrado.getCodigoProduto().getId());

        estoqueDAODB1.excluir(estoqueCadastrado);
    }

    @Test
    public void atualizar() throws DAOException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
        ProdutoDAODB2 dao = new ProdutoDAODB2();
        EstoqueDAODB2 estoqueDAODB1 = new EstoqueDAODB2();
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

        Estoque estoque = new Estoque();
        estoque.setCodigoProduto(produto);
        estoque.setQuantidade(128);

        Estoque estoque1 = new Estoque();
        estoque1.setCodigoProduto(produto1);
        estoque1.setQuantidade(128);

        estoqueDAODB1.cadastrar(estoque);
        estoqueDAODB1.cadastrar(estoque1);

        Estoque estoqueCadastrado = estoqueDAODB1.consultar(estoque.getId().toString());

        estoqueCadastrado.setQuantidade(256);
        estoqueDAODB1.alterar(estoqueCadastrado);

        Estoque estoqueAlterado = estoqueDAODB1.consultar(estoqueCadastrado.getId().toString());

        assertEquals(produto.getId(), estoqueAlterado.getCodigoProduto().getId());
        assertEquals(256, (int)estoqueAlterado.getQuantidade());

        estoqueDAODB1.excluir(estoqueAlterado);
        estoqueDAODB1.excluir(estoque1);

    }

    @Test
    public void buscarTodos() throws DAOException, TipoChaveNaoEncontradaException {
        ProdutoDAODB2 dao = new ProdutoDAODB2();
        EstoqueDAODB2 estoqueDAODB1 = new EstoqueDAODB2();
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

        Estoque estoque = new Estoque();
        estoque.setCodigoProduto(produto);
        estoque.setQuantidade(128);

        Estoque estoque1 = new Estoque();
        estoque1.setCodigoProduto(produto1);
        estoque1.setQuantidade(128);

        estoqueDAODB1.cadastrar(estoque);
        estoqueDAODB1.cadastrar(estoque1);


        Collection<Estoque> list = estoqueDAODB1.buscarTodos();
        assertNotNull(list);

        list.forEach(est -> {
            try {
                estoqueDAODB1.excluir(est);
            } catch (DAOException e) {
                throw new RuntimeException(e);
            }
        });
    }

}