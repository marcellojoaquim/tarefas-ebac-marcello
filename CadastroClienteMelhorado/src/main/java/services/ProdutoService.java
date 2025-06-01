package services;

import dao.IProdutoDAO;
import domain.Produto;
import services.generics.GenericService;


public class ProdutoService extends GenericService<Produto> implements IProdutoService {

    public ProdutoService(IProdutoDAO dao){
        super(dao);
    }

    @Override
    public Class<Produto> getTipoClasse() {
        return Produto.class;
    }

    @Override
    public void atualiarDados(Produto entity, Produto entityCadastrado) {
        entityCadastrado.setCodigo(entity.getCodigo());
        entityCadastrado.setDescricao(entity.getDescricao());
        entityCadastrado.setNome(entity.getNome());
        entityCadastrado.setValor(entity.getValor());
    }


}
