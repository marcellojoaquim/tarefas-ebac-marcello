package br.com.joaquim.dao;

import br.com.joaquim.dao.jdbc.ConnectionFactory;
import br.com.joaquim.domain.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public Integer atualizar(Cliente cliente) throws SQLException {
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = ConnectionFactory.getConnection();
            String sql = getSqlUpdate();
            statement = conn.prepareStatement(sql);
            adicionaParametrosUpdate(statement, cliente);
            return statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            if(statement != null && !statement.isClosed()) {
                statement.close();
            }
            if(conn != null && !conn.isClosed()) {
                conn.close();
            }
        }
    }

    @Override
    public List<Cliente> buscarTodos() throws SQLException {
        ResultSet resultSet;
        Connection conn = null;
        PreparedStatement statement = null;
        List<Cliente> list = new ArrayList<>();
        try {
            conn = ConnectionFactory.getConnection();
            String sql = getSqlBuscarTodos();
            statement = conn.prepareStatement(sql);

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(resultSet.getLong("id"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setCodigo(resultSet.getString("codigo"));
                list.add(cliente);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection(statement, conn);
        }
        return list;
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
        stringBuilder.append("SET codigo = ?, nome = ? ");
        stringBuilder.append("WHERE id = ?");
        return stringBuilder.toString();
    }

    private void adicionaParametrosUpdate(PreparedStatement preparedStatement, Cliente cliente) throws SQLException {
        preparedStatement.setString(1, cliente.getCodigo());
        preparedStatement.setString(2, cliente.getNome());
        preparedStatement.setLong(3, cliente.getId());
    }

    private String getSqlBuscarTodos() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT id, nome, codigo ");
        stringBuilder.append("FROM tb_cliente");
        return stringBuilder.toString();
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

    public void closeConnection(PreparedStatement statement, Connection connection) throws SQLException {
        if(statement != null && !statement.isClosed()) {
            statement.close();
        }
        if(connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
