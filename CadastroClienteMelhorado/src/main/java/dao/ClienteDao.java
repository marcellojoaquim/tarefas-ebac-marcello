package dao;

import dao.generics.GenericDAO;
import domain.Cliente;


public class ClienteDao extends GenericDAO<Cliente> implements IClienteDao {

    public ClienteDao() {
        super();
    }

    @Override
    public Class<Cliente> getTipoClasse() {
        return Cliente.class;
    }

    @Override
    public void atualiarDados(Cliente entity, Cliente entityCadastrado) {

    }
}
