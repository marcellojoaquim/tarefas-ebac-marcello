package dao;

public class ClienteDaoMock implements IClienteDao {

    @Override
    public String salvar() {
        return null;
    }

    @Override
    public String buscar() {
        return "Sucesso";
    }

    @Override
    public boolean excluir() {
        return true;
    }

    @Override
    public String atualizar() {
        return "Sucesso";
    }
}