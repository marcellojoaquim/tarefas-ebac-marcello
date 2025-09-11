package br.com.joaquim.dao;

import br.com.joaquim.dao.jdbc.ConnectionFactory;
import br.com.joaquim.domain.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao implements IProdutoDAO{
    @Override
    public Integer cadastrar(Produto produto) throws SQLException {
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = ConnectionFactory.getConnection();
            String sql = getSqlInsert();
            statement = conn.prepareStatement(sql);
            adicionaParametrosInsert(statement, produto);
            return statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
           closeConnection(statement, conn, null);
        }
    }

    @Override
    public Produto consultar(String codigo) throws SQLException {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Produto savedProduto = new Produto();
        try {
            conn = ConnectionFactory.getConnection();
            String sql = getSqlConsulta();
            statement = conn.prepareStatement(sql);
            insereParametrosConsulta(statement, codigo);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                savedProduto.setId(resultSet.getLong("id"));
                savedProduto.setNome(resultSet.getString("nome"));
                savedProduto.setCodigo(resultSet.getString("codigo"));
                savedProduto.setDescricao(resultSet.getString("descricao"));
            }
            return savedProduto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection(statement, conn, resultSet);
        }
    }

    @Override
    public Integer excluir(Produto produto) throws SQLException {
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = ConnectionFactory.getConnection();
            String sql = getSqlExcluir();
            statement = conn.prepareStatement(sql);
            adicionaParametrosExcluir(statement, produto);
            return statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection(statement,conn, null);
        }
    }


    @Override
    public Integer atualizar(Produto produto) throws SQLException {
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            conn = ConnectionFactory.getConnection();
            String sql = getSqlUpdate();
            statement = conn.prepareStatement(sql);
            adicionaParametrosUpdate(statement, produto);
            return statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection(statement, conn, null);
        }
    }

    @Override
    public List<Produto> buscarTodos() throws SQLException {
        PreparedStatement statement = null;
        Connection conn = null;
        ResultSet resultSet = null;
        List<Produto> produtoList = new ArrayList<>();
        try {
            conn = ConnectionFactory.getConnection();
            String sql = getSqlBuscarTodos();
            statement = conn.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Produto produto = new Produto();
                produto.setId(resultSet.getLong("id"));
                produto.setNome(resultSet.getString("nome"));
                produto.setCodigo(resultSet.getString("codigo"));
                produto.setDescricao(resultSet.getString("descricao"));
                produtoList.add(produto);
            }
            return produtoList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection(statement, conn, resultSet);
        }
    }

    private String getSqlInsert() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT INTO tb_produto (id, nome, codigo, descricao) ");
        stringBuilder.append("VALUES (NEXTVAL('gen_id_produto'),?,?,?)");
        return stringBuilder.toString();
    }

    private void adicionaParametrosInsert(PreparedStatement statement, Produto produto) throws SQLException {
        statement.setString(1, produto.getNome());
        statement.setString(2, produto.getCodigo());
        statement.setString(3, produto.getDescricao());
    }

    private String getSqlConsulta() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT id, nome, codigo,  descricao ");
        stringBuilder.append("FROM tb_produto ");
        stringBuilder.append("WHERE codigo = ?");
        return stringBuilder.toString();
    }

    private void insereParametrosConsulta(PreparedStatement statement, String codigo) throws SQLException{
        statement.setString(1, codigo);
    }

    private void closeConnection(PreparedStatement statement, Connection connection, ResultSet resultSet) throws SQLException {
        if(statement != null && !statement.isClosed()) {
            statement.close();
        }
        if(connection != null && !connection.isClosed()) {
            connection.close();
        }
        if(resultSet != null && !resultSet.isClosed()){
            resultSet.close();
        }
    }

    private String getSqlExcluir() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DELETE FROM tb_produto ");
        stringBuilder.append("WHERE codigo = ?");
        return stringBuilder.toString();
    }

    private void adicionaParametrosExcluir(PreparedStatement statement, Produto produto) throws SQLException {
        statement.setString(1, produto.getCodigo());
    }

    private String getSqlUpdate() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE tb_produto ");
        stringBuilder.append("SET codigo = ?, nome = ?, descricao = ? ");
        stringBuilder.append("WHERE id = ?");
        return stringBuilder.toString();
    }

    private void adicionaParametrosUpdate(PreparedStatement preparedStatement, Produto produto) throws SQLException {
        preparedStatement.setString(1, produto.getCodigo());
        preparedStatement.setString(2, produto.getNome());
        preparedStatement.setString(3, produto.getDescricao());
        preparedStatement.setLong(4, produto.getId());
    }

    private String getSqlBuscarTodos() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT id, nome, codigo, descricao ");
        stringBuilder.append("FROM tb_produto ");
        return stringBuilder.toString();
    }
}
