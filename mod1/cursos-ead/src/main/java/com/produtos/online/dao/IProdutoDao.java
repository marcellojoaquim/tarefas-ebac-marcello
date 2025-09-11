package com.produtos.online.dao;

import com.produtos.online.dao.exceptions.NotFoundException;
import com.produtos.online.domain.Produto;

import java.util.List;

public interface IProdutoDao {

    Produto cadastrar(Produto produto);
    void delete(Long id) throws NotFoundException;
    Produto buscar(Long id) throws NotFoundException;
    List<Produto> buscarTodos();
    Produto atualiar(Long id, Produto produto) throws NotFoundException;
    Produto buscarPorCodigo(String codigo) throws NotFoundException;

}
