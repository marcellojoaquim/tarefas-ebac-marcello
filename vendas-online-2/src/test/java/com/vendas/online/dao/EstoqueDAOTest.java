package com.vendas.online.dao;

import com.vendas.online.domain.Estoque;
import com.vendas.online.domain.Produto;
import com.vendas.online.exceptions.DAOException;
import com.vendas.online.exceptions.TipoChaveNaoEncontradaException;
import static org.junit.Assert.*;
import org.junit.Test;

import java.math.BigDecimal;

public class EstoqueDAOTest {

    @Test
    public void inserir() throws DAOException, TipoChaveNaoEncontradaException {
        ProdutoDAO dao = new ProdutoDAO();
        EstoqueDAO estoqueDAO = new EstoqueDAO();
        Produto produto = new Produto();
        produto.setNome("Produto 01");
        produto.setCodigo("prod-01");
        produto.setDescricao("descricao produto 01");
        produto.setFabricante("China");
        produto.setValor(new BigDecimal(128.256));

        dao.cadastrar(produto);

        Estoque estoque = new Estoque();
        estoque.setQuantidade(128);
        estoque.setCodigoProduto(produto.getCodigo());

        boolean result = estoqueDAO.cadastrar(estoque);
        assertTrue(result);

    }
}