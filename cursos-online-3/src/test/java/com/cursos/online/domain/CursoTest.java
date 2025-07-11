package com.cursos.online.domain;


import com.cursos.online.dao.CursoDao;
import com.cursos.online.dao.ICursoDao;
import org.junit.Assert;
import org.junit.Test;

public class CursoTest {

    private ICursoDao cursoDao;

    public CursoTest() {
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