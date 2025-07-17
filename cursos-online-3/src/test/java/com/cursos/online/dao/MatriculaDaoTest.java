package com.cursos.online.dao;

import com.cursos.online.domain.Curso;
import com.cursos.online.domain.Matricula;
import org.junit.Assert;
import org.junit.Test;

import java.time.Instant;

public class MatriculaDaoTest {

    private IMatriculaDao matriculaDao;
    private ICursoDao cursoDao;

    public MatriculaDaoTest() {
        matriculaDao = new MatriculaDao("cursos-online");
        cursoDao = new CursoDao("cursos-online");
    }

    @Test
    public void testCadastrar() {
        Curso curso = criaCurso("A1");
        Matricula matricula = new Matricula();
        matricula.setDataMatricula(Instant.now());
        matricula.setCodigo("M1");
        matricula.setStatus("ATIVA");
        matricula.setValor(2500d);
        matricula.setCurso(curso);

        matricula = matriculaDao.cadastrar(matricula);

        Assert.assertNotNull(matricula);

        //matriculaDao.delete(matricula);
    }

    @Test
    public void testDelete() {
        Matricula matricula = new Matricula();
        matricula.setDataMatricula(Instant.now());
        matricula.setCodigo("M1");
        matricula.setStatus("ATIVA");
        matricula.setValor(2500d);

        matriculaDao.cadastrar(matricula);

    }


    private Curso criaCurso(String codigo){
        Curso curso = new Curso();
        curso.setCodigo(codigo);
        curso.setDescricao("Criado no teste Matricula");
        curso.setNome("Criado no teste Matricula");
        return cursoDao.cadastrar(curso);
    }
}