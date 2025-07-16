package com.produtos.online.dao;

import com.produtos.online.dao.exceptions.NotFoundException;
import com.produtos.online.dao.singleton.SingletonEntityManagerFactory;
import com.produtos.online.domain.Produto;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ProdutoDaoTest {

    private IProdutoDao produtoDao;

    public ProdutoDaoTest() {
        produtoDao = new ProdutoDao("cursos.ead");
    }
    @After
    public void tearDown() {
        SingletonEntityManagerFactory.closeEntityManager();
        List<Produto> list = produtoDao.buscarTodos();
        list.forEach(produto -> {
            try {
                produtoDao.delete(produto.getId());
            } catch (NotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Test
    public void cadastrar() throws NotFoundException {
        Produto produto = new Produto();
        produto.setCodigo("P1");
        produto.setDescricao("Teste criacao tabela produto");
        produto.setNome("Produto 01");
        produto = produtoDao.cadastrar(produto);

        Assert.assertNotNull(produto);

        produtoDao.delete(produto.getId());
    }

    @Test
    public void delete() throws NotFoundException {

        Produto produto = new Produto();
        produto.setCodigo("P1");
        produto.setDescricao("Teste criacao tabela produto");
        produto.setNome("Produto 01");
        produto = produtoDao.cadastrar(produto);
        final Long id = produto.getId();
        produtoDao.delete(produto.getId());

        NotFoundException thrown = Assert.assertThrows(NotFoundException.class, ()-> {
           produtoDao.buscar(id);
        });

        Assert.assertEquals("Produto não encontrado", thrown.getMessage());
    }

    @Test
    public void buscar() throws NotFoundException {
        Produto saved;
        Produto produto = new Produto();
        produto.setCodigo("P1");
        produto.setDescricao("Teste criacao tabela produto");
        produto.setNome("Produto 01");
        produto = produtoDao.cadastrar(produto);

        saved = produtoDao.buscar(produto.getId());
        Assert.assertNotNull(saved);
        Assert.assertEquals(produto.getCodigo(), saved.getCodigo());
    }

    @Test
    public void buscarTodos() {
        Produto produto = new Produto();
        produto.setCodigo("P1");
        produto.setDescricao("Teste criacao tabela produto");
        produto.setNome("Produto 01");

        Produto produto2 = new Produto();
        produto2.setCodigo("P2");
        produto2.setDescricao("Teste criacao tabela produto");
        produto2.setNome("Produto 02");

        produtoDao.cadastrar(produto);
        produtoDao.cadastrar(produto2);

        List<Produto> list = produtoDao.buscarTodos();

        Assert.assertNotNull(list);
        Assert.assertEquals(2, list.size());
        Assert.assertEquals("Produto 02", list.get(1).getNome());
    }

    @Test
    public void atualizar() throws NotFoundException {
        Produto saved;
        Produto produto = new Produto();
        produto.setCodigo("P1");
        produto.setDescricao("Teste criacao tabela produto");
        produto.setNome("Produto 01");

        produtoDao.cadastrar(produto);
        saved = produtoDao.buscar(produto.getId());

        Produto produto2 = new Produto();
        produto2.setCodigo("P2");
        produto2.setDescricao("Teste produto 2");
        produto2.setNome("Produto 02");

        Produto updated = produtoDao.atualiar(saved.getId(), produto2);

        Assert.assertEquals(produto2.getNome(), updated.getNome());
        Assert.assertEquals(produto2.getCodigo(), updated.getCodigo());
    }

}