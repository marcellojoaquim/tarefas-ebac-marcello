package services;

import domain.Produto;
import services.generics.IGenericService;

public interface IProdutoService extends IGenericService<Produto> {


    Class<Produto> getTipoClasse();

    void atualiarDados(Produto entity, Produto entityCadastrado);
}
