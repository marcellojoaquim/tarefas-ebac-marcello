package br.com.joaquim.dao;

import br.com.joaquim.domain.Cliente;

import java.sql.SQLException;

public interface IClienteDao {
    public Integer cadastrar(Cliente cliente) throws SQLException;
    Cliente consultar(String codigo) throws SQLException;
    Integer excluir(Cliente cliente) throws SQLException;
}
