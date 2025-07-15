package com.cursos.online.dao;

import com.cursos.online.domain.Matricula;
import org.junit.Assert;
import org.junit.Test;

import java.time.Instant;

public class MatriculaDaoTest {

    private IMatriculaDao matriculaDao;

    public MatriculaDaoTest() { matriculaDao = new MatriculaDao(); }

    @Test
    public void testCadastrar() {
        Matricula matricula = new Matricula();
        matricula.setDataMatricula(Instant.now());
        matricula.setCodigo("M1");
        matricula.setStatus("ATIVA");
        matricula.setValor(2500d);

        matricula = matriculaDao.cadastrar(matricula);

        Assert.assertNotNull(matricula);

        matriculaDao.delete(matricula);
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
}