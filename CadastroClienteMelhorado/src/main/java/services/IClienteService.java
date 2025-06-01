package services;

import domain.Cliente;
import exception.TipoChaveNaoEncontradaException;
import services.generics.IGenericService;

public interface IClienteService {

    Class<Cliente> getTipoClasse();

    void atualiarDados(Cliente entity, Cliente entityCadastrado);

    Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;

    Cliente buscarPorCPF(Long cpf);

    void excluir(Long cpf);

    void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}
