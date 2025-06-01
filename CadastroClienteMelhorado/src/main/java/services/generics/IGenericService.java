package services.generics;

import domain.Cliente;
import domain.Persistente;
import exception.TipoChaveNaoEncontradaException;

public interface IGenericService <T extends Persistente>{

    Boolean salvar(T entity) throws TipoChaveNaoEncontradaException;
    T buscarPorCodigo(Long valor);
    void excluir(Long valor);
    void alterar(T entity) throws TipoChaveNaoEncontradaException;
}
