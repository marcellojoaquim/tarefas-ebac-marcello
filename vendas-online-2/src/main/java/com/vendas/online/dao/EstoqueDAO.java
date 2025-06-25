package com.vendas.online.dao;

import com.vendas.online.dao.generic.GenericDAO;
import com.vendas.online.domain.Estoque;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class EstoqueDAO extends GenericDAO<Estoque, String> implements IEstoqueDAO {

    public EstoqueDAO() {
        super();
    }

    @Override
    public Class<Estoque> getTipoClasse() {
        return Estoque.class;
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
        return "DELETE FROM tb_estoque WHERE codigo_produto = ?";
    }

    @Override
    protected String getQueryAtualizacao() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE tb_estoque ");
        stringBuilder.append("SET quantidade = ?, ");
        stringBuilder.append("codigo_produto = ? ");
        stringBuilder.append("WHERE codigo_produto = ?");
        return stringBuilder.toString();
    }

    @Override
    protected void setParametrosQueryInsercao(PreparedStatement stmInsert, Estoque entity) throws SQLException {
        stmInsert.setLong(1, entity.getQuantidade());
        stmInsert.setString(2, entity.getCodigoProduto());
    }

    @Override
    protected void setParametrosQueryExclusao(PreparedStatement stmDelete, String valor) throws SQLException {
        stmDelete.setString(1, valor);
    }

    @Override
    protected void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Estoque entity) throws SQLException {
        stmUpdate.setLong(1, entity.getQuantidade());
        stmUpdate.setString(2, entity.getCodigoProduto());
        stmUpdate.setString(3, entity.getCodigoProduto());
    }

    @Override
    protected void setParametrosQuerySelect(PreparedStatement stmUpdate, String valor) throws SQLException {
        stmUpdate.setString(1, valor);
    }
}
