package com.carros.dao;


import com.carros.domain.Acessorio;
import com.carros.domain.Carro;
import com.carros.domain.Marca;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;

public class CarroDaoTest {

    private ICarroDao carroDao;
    private IAcessorioDao acessorioDao;
    private IMarcaDao marcaDao;

    public CarroDaoTest() {
        carroDao = new CarroDao("carros");
        acessorioDao = new AcessorioDao("carros");
        marcaDao = new MarcaDao("carros");
    }

    @Test
    public void cadastrarTest() {
        Acessorio acessorio = new Acessorio();
        acessorio.setNome("jogo de rodas");
        acessorio.setDescricao("Jogão de rodas cabuloso para opalas velhos");
        acessorioDao.cadastrar(acessorio);


        Acessorio acessorio1 = new Acessorio();
        acessorio1.setNome("Capô personalizado");
        acessorio1.setDescricao("Capô personalizado caveira justiceiro");
        acessorioDao.cadastrar(acessorio1);

        List<Acessorio> acessorioList = acessorioDao.buscarTodos();

        Marca marca = new Marca();
        marca.setNome("General Motors");
        marcaDao.cadastrar(marca);


        Carro carro = new Carro();
        carro.setAno(2020);
        carro.setModelo("Opala SS");
        carro.setAcessorios(acessorioList);
        carro.setMarca(marca);

        carro = carroDao.cadastrar(carro);

        assertEquals("General Motors", carro.getMarca().getNome());

    }

    @Test
    public void buscarCarrosPorMarca() {
        Acessorio acessorio = new Acessorio();
        acessorio.setNome("jogo de rodas");
        acessorio.setDescricao("Jogão de rodas cabuloso para opalas velhos");
        acessorioDao.cadastrar(acessorio);


        Acessorio acessorio1 = new Acessorio();
        acessorio1.setNome("Capô personalizado");
        acessorio1.setDescricao("Capô personalizado caveira justiceiro");
        acessorioDao.cadastrar(acessorio1);

        List<Acessorio> acessorioList = acessorioDao.buscarTodos();

        Marca marca = new Marca();
        marca.setNome("General Motors");
        marcaDao.cadastrar(marca);

        Marca marca1 = new Marca();
        marca1.setNome("WV");
        marcaDao.cadastrar(marca1);

        Carro carro = new Carro();
        carro.setAno(2020);
        carro.setModelo("Opala SS");
        carro.setAcessorios(acessorioList);
        carro.setMarca(marca);

        carro = carroDao.cadastrar(carro);

        Carro carro1 = new Carro();
        carro1.setAno(2019);
        carro1.setModelo("Fusca");
        carro1.setAcessorios(null);
        carro1.setMarca(marca1);

        carro1 = carroDao.cadastrar(carro1);

        Carro carro2 = new Carro();
        carro2.setAno(2025);
        carro2.setModelo("Kombi");
        carro2.setAcessorios(acessorioList);
        carro2.setMarca(marca1);

        carro2 = carroDao.cadastrar(carro2);


        List<Carro> carroList = carroDao.buscarPorMarca(marca1);

        assertEquals(2, carroList.size());

    }
}