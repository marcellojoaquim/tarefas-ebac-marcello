package com.carros.dao;


import com.carros.domain.Acessorio;
import org.junit.Test;

import static org.junit.Assert.*;

public class AcessorioDaoTest {

    private IAcessorioDao acessorioDao;

    public AcessorioDaoTest() {
        acessorioDao = new AcessorioDao("carros");
    }

    @Test
    public void cadastrarTest() {
        Acessorio acessorio = new Acessorio();
        acessorio.setNome("para-brisa");
        acessorio.setDescricao("para-brisa dianteiro");

        acessorio = acessorioDao.cadastrar(acessorio);

        assertEquals("para-brisa", acessorio.getNome());
    }
}