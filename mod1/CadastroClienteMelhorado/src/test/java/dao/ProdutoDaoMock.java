package dao;

import dao.generics.SingletonMap;
import domain.Produto;
import exception.TipoChaveNaoEncontradaException;

import java.util.Collection;


public class ProdutoDaoMock implements IProdutoDAO{
    private  SingletonMap singletonMap;
    public ProdutoDaoMock() {
        singletonMap = SingletonMap.getInstance();
    }
    @Override
    public Boolean cadastrar(Produto entity) throws TipoChaveNaoEncontradaException {
        return true;
    }

    @Override
    public void excluir(Long valor) {

    }

    @Override
    public void alterar(Produto entity) throws TipoChaveNaoEncontradaException {

    }

    @Override
    public Produto consultar(Long valor) {
        Produto produto = new Produto();
        produto.setCodigo(valor);
        return produto;
    }

    @Override
    public Collection<Produto> buscarTodos() {
        return null;
    }
}
