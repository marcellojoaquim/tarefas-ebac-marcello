package com.cursos.online.dao;

import com.cursos.online.domain.Curso;
import org.junit.Assert;
import org.junit.Test;

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
    }
}