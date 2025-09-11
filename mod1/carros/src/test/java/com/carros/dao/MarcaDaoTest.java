package com.carros.dao;

import com.carros.domain.Marca;
import org.junit.Test;

import static  org.junit.Assert.*;

public class MarcaDaoTest {
    private IMarcaDao marcaDao;

    public MarcaDaoTest(){
        marcaDao = new MarcaDao("carros");
    }

    @Test
    public void cadastrarTest() {

        Marca marca = new Marca();
        marca.setNome("Fiat test");
        marca.setCarro(null);

        marca = marcaDao.cadastrar(marca);

        assertEquals("Fiat test", marca.getNome());

    }

}