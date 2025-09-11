package com.carros.dao;

import com.carros.domain.Acessorio;

import java.util.List;

public interface IAcessorioDao {

    Acessorio cadastrar(Acessorio acessorio);
    List<Acessorio> buscarTodos();
}
