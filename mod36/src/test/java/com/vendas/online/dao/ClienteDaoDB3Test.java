package com.vendas.online.dao;

import com.vendas.online.domain.Cliente;
import com.vendas.online.exceptions.DAOException;
import com.vendas.online.exceptions.TipoChaveNaoEncontradaException;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ClienteDaoDB3Test {

    @Test
    public void cadastrarCliente() throws DAOException, TipoChaveNaoEncontradaException {
        ClienteDaoDB3 dao = new ClienteDaoDB3();
        Cliente cliente = new Cliente();
        cliente.setCpf(12345678900L);
        cliente.setNome("Cliente 01");
        cliente.setSobreNome("Sobrenome 01");
        cliente.setEnd("Endereco");
        cliente.setNumero(128);
        cliente.setCidade("Recife");
        cliente.setEstado("PE");
        cliente.setTel(98765432100L);

        Cliente result = dao.cadastrar(cliente);
        assertNotNull(result);

        dao.excluir(cliente);
    }
}