package services;

import dao.IClienteDao;
import domain.Cliente;
import exception.TipoChaveNaoEncontradaException;
import services.generics.GenericService;

public class ClienteService extends GenericService<Cliente> implements IClienteService {

    public ClienteService(IClienteDao clienteDao) {
        super(clienteDao);
    }

    @Override
    public Class<Cliente> getTipoClasse() {
        return null;
    }

    @Override
    public void atualiarDados(Cliente entity, Cliente entityCadastrado) {

    }

    @Override
    public Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException {
        return true;
    }

    @Override
    public Cliente buscarPorCPF(Long cpf) {
        return this.dao.consultar(cpf);
    }
}
