package services;

import dao.IProdutoDAO;
import dao.ProdutoDAO;
import dao.ProdutoDaoMock;
import domain.Produto;
import exception.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;


public class ProdutoServiceTest {
    private IProdutoService produtoService;
    private Produto produto;

    public ProdutoServiceTest() {
        IProdutoDAO dao = new ProdutoDAO();
        produtoService = new ProdutoService(dao);
    }

    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        produto = new Produto();
        produto.setCodigo(1L);
        produto.setDescricao("Produto description");
        produto.setNome("Produto P");
        produto.setValor(BigDecimal.TEN);
        produtoService.salvar(produto);
    }

    @Test
    public void pesquisar() {
        Produto produto = this.produtoService.buscarPorCodigo(this.produto.getCodigo());
        Assert.assertNotNull(produto);
    }

    @Test
    public void salvar() throws TipoChaveNaoEncontradaException {
        produto.setCodigo(1L);
        Boolean retorno = produtoService.salvar(produto);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluir() {
        produtoService.excluir(produto.getCodigo());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        produto.setNome("Tv tv");
        produtoService.alterar(produto);

        Assert.assertEquals("Tv tv", produto.getNome());
    }

}