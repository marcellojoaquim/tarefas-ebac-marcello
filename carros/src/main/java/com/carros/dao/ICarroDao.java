package com.carros.dao;

import com.carros.domain.Carro;
import com.carros.domain.Marca;

import java.util.List;

public interface ICarroDao {

    Carro cadastrar(Carro carro);
    List<Carro> buscarPorMarca(Marca marca);
    List<Carro> buscarPorMarcaCriteria(Marca marca);
}
