package com.cursos.online.dao;

import com.cursos.online.domain.Curso;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CursoDaoTest {

    private ICursoDao cursoDao;

    public CursoDaoTest() {
        cursoDao = new CursoDao("cursos-online");
    }
    @Test
    public void cadastrar() {
        Curso curso = new Curso();
        curso.setCodigo("A1");
        curso.setDescricao("Teste criacao tabela");
        curso.setNome("Curso tabela");
        curso = cursoDao.cadastrar(curso);

        Assert.assertNotNull(curso);
        Assert.assertEquals("Curso tabela", curso.getNome());

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
        Assert.assertEquals("Teste criacao tabela", saved.getDescricao());

        cursoDao.delete(curso);
    }

    @Test
    public void buscarTodos() {
        List<Curso> list;
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

    @Test
    public void testAtualizar() {
        Curso curso = new Curso();
        curso.setCodigo("A1");
        curso.setDescricao("Teste criacao tabela");
        curso.setNome("Curso tabela");

        cursoDao.cadastrar(curso);

        Curso saved = cursoDao.buscar(curso.getId());
        Assert.assertNotNull(saved);
        Assert.assertEquals("Curso tabela", saved.getNome());

        Curso curso2 = new Curso();
        curso2.setCodigo("A2");
        curso2.setDescricao("Teste criacao tabela 2");
        curso2.setNome("Curso tabela 2");

        Curso updated = cursoDao.atualizar(saved.getId(), curso2);

        Assert.assertEquals(curso2.getNome(), updated.getNome());
        Assert.assertEquals(curso2.getCodigo(), updated.getCodigo());

        cursoDao.delete(updated);
    }
}