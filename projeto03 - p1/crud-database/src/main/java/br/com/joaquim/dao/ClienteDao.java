package br.com.joaquim.dao;

import br.com.joaquim.dao.jdbc.ConnectionFactory;
import br.com.joaquim.domain.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDao implements IClienteDao {

    @Override
    public Integer cadastrar(Cliente cliente) throws SQLException {
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = ConnectionFactory.getConnection();
            String sql = getSqlInsert();
            statement = conn.prepareStatement(sql);
            adicionaParametrosInsert(statement, cliente);
            return statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if(statement != null && !statement.isClosed()) {
                statement.close();
            }
            if(conn != null && !conn.isClosed()) {
                conn.close();
            }
        }
    }

    @Override
    public Cliente consultar(String codigo) throws SQLException {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Cliente cliente = null;
        try {
            conn = ConnectionFactory.getConnection();
            String sql = getSqlConsulta();
            statement = conn.prepareStatement(sql);
            adicionaParamentrosSelect(statement, codigo);
            resultSet = statement.executeQuery();
            if(resultSet.next()) {
                cliente = new Cliente();
                cliente.setId(resultSet.getLong("id"));
                cliente.setCodigo(resultSet.getString("codigo"));
                cliente.setNome(resultSet.getString("nome"));
                return cliente;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if(statement != null && !statement.isClosed()) {
                statement.close();
            }
            if(conn != null && !conn.isClosed()) {
                conn.close();
            }
        }
    }

    @Override
    public Integer excluir(Cliente cliente) throws SQLException {
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = ConnectionFactory.getConnection();
            String sql = getSqlExcluir();
            statement = conn.prepareStatement(sql);
            adicionaParametrosExcluir(statement, cliente);
            return statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if(statement != null && !statement.isClosed()) {
                statement.close();
            }
            if(conn != null && !conn.isClosed()) {
                conn.close();
            }
        }
    }

    private String getSqlConsulta() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT id, nome, codigo FROM tb_cliente ");
        stringBuilder.append("WHERE codigo = ?");
        return stringBuilder.toString();
    }

    private void adicionaParamentrosSelect(PreparedStatement statement, String codigo) throws SQLException {
        statement.setString(1, codigo);
    }


    private void adicionaParametrosInsert(PreparedStatement statement, Cliente cliente) throws SQLException {
        statement.setString(1, cliente.getCodigo());
        statement.setString(2, cliente.getNome());
    }

    private String getSqlInsert() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT INTO tb_cliente (id, codigo, nome) ");
        stringBuilder.append("VALUES (NEXTVAL('gen_id_cliente'),?,?)");
        return stringBuilder.toString();
    }

    private String getSqlUpdate() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE tb_cliente ");
        stringBuilder.append("SET nome = ?, codigo = ?");
        stringBuilder.append("WHERE id = ?");
        return stringBuilder.toString();
    }

    private void adicionaParametrosUpdate(PreparedStatement preparedStatement, Cliente cliente) throws SQLException {
        preparedStatement.setString(1, cliente.getNome());
        preparedStatement.setString(2, cliente.getCodigo());
        preparedStatement.setString(3, cliente.getId().toString());
    }

    private String getSqlExcluir() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DELETE FROM tb_cliente ");
        stringBuilder.append("WHERE codigo = ?");
        return stringBuilder.toString();
    }

    private void adicionaParametrosExcluir(PreparedStatement preparedStatement, Cliente cliente) throws SQLException {
        preparedStatement.setString(1, cliente.getCodigo());
    }
}
