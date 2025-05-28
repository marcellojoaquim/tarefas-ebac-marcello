package dao;

public class ContratoDao implements IContratoDao {

    @Override
    public String salvar() {
        //throw new UnsupportedOperationException("Não funciona com o banco");
        return "Sucesso";
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