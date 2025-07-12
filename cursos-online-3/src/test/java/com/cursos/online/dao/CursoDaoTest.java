package com.cursos.online.dao;

import com.cursos.online.domain.Curso;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CursoDaoTest {

    private ICursoDao cursoDao;

    public CursoDaoTest() {
        cursoDao = new CursoDao();
    }
    @Test
    public void cadastrar() {
        Curso curso = new Curso();
        curso.setCodigo("A1");
        curso.setDescricao("Teste criacao tabela");
        curso.setNome("Curso tabela");
        curso = cursoDao.cadastrar(curso);

        Assert.assertNotNull(curso);

        cursoDao.delete(curso);
    }

    @Test
    public void delete() {
        Curso curso = new Curso();
        Curso deleted;
        curso.setCodigo("A1");
        curso.setDescricao("Teste criacao tabela");
        curso.setNome("Curso tabela");
        curso = cursoDao.cadastrar(curso);

        cursoDao.delete(curso);

        deleted = cursoDao.buscar(curso.getId());

        Assert.assertNull(deleted);
    }

    @Test
    public void buscar() {
        Curso saved;
        Curso curso = new Curso();
        curso.setCodigo("A1");
        curso.setDescricao("Teste criacao tabela");
        curso.setNome("Curso tabela");
        curso = cursoDao.cadastrar(curso);

        saved = cursoDao.buscar(curso.getId());

        Assert.assertNotNull(saved);
        Assert.assertEquals(curso.getCodigo(), saved.getCodigo());

        cursoDao.delete(curso);
    }

    @Test
    public void buscarTodos() {
        List<Curso> list = new ArrayList<>();
        Curso curso = new Curso();
        curso.setCodigo("A1");
        curso.setDescricao("Teste criacao tabela");
        curso.setNome("Curso tabela");

        cursoDao.cadastrar(curso);

        Curso curso2 = new Curso();
        curso2.setCodigo("A2");
        curso2.setDescricao("Teste criacao tabela 2");
        curso2.setNome("Curso tabela 2");

        cursoDao.cadastrar(curso2);

        list = cursoDao.buscarTodos();

        Assert.assertEquals(2, list.size());

        list.forEach(c -> {
            cursoDao.delete(c);
        });
    }
}