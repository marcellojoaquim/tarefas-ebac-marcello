package com.vendas.online.dao;

import com.vendas.online.dao.generic.GenericDAO;
import com.vendas.online.domain.Estoque;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class EstoqueDAO extends GenericDAO<Estoque, Long> implements IEstoqueDAO {

    public EstoqueDAO() {
        super();
    }

    @Override
    public Class<Estoque> getTipoClasse() {
        return null;
    }

    @Override
    public void atualizarDados(Estoque entity, Estoque entityCadastrado) {
        entityCadastrado.setQuantidade(entity.getQuantidade());
    }

    @Override
    protected String getQueryInsercao() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT INTO tb_estoque (id, quantidade, codigo_produto) ");
        stringBuilder.append("VALUES (NEXTVAL('sq_estoque'),?,?)");
        return stringBuilder.toString();
    }

    @Override
    protected String getQueryExclusao() {
        return "";
    }

    @Override
    protected String getQueryAtualizacao() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE tb_estoque ");
        stringBuilder.append("SET quantidade = ?");
        stringBuilder.append("WHERE id = ?");
        return stringBuilder.toString();
    }

    @Override
    protected void setParametrosQueryInsercao(PreparedStatement stmInsert, Estoque entity) throws SQLException {
        stmInsert.setLong(1, entity.getQuantidade());
        stmInsert.setString(2, entity.getCodigoProduto());
    }

    @Override
    protected void setParametrosQueryExclusao(PreparedStatement stmDelete, Long valor) throws SQLException {

    }

    @Override
    protected void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Estoque entity) throws SQLException {

    }

    @Override
    protected void setParametrosQuerySelect(PreparedStatement stmUpdate, Long valor) throws SQLException {

    }
}
