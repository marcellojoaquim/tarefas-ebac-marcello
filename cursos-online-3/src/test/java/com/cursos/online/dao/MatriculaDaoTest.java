package com.cursos.online.dao;

import com.cursos.online.domain.Aluno;
import com.cursos.online.domain.Curso;
import com.cursos.online.domain.Matricula;
import org.junit.Assert;
import org.junit.Test;

import java.time.Instant;

public class MatriculaDaoTest {

    private IMatriculaDao matriculaDao;
    private ICursoDao cursoDao;
    private IAlunoDao alunoDao;

    public MatriculaDaoTest() {
        matriculaDao = new MatriculaDao("cursos-online");
        cursoDao = new CursoDao("cursos-online");
        alunoDao = new AlunoDao("cursos-online");
    }

    @Test
    public void testCadastrar() {
        Aluno aluno = criarAluno("Aluno 01");
        Curso curso = criaCurso("A1");

        Matricula matricula = new Matricula();
        matricula.setDataMatricula(Instant.now());
        matricula.setCodigo("M1");
        matricula.setStatus("ATIVA");
        matricula.setValor(2500d);
        matricula.setCurso(curso);
        matricula.setAluno(aluno);

        matricula = matriculaDao.cadastrar(matricula);

        Assert.assertNotNull(matricula);

        matriculaDao.delete(matricula.getId(), matricula);
    }

    @Test
    public void testDelete() {
        Aluno aluno = criarAluno("Aluno 01");
        Curso curso = criaCurso("A1");
        Matricula matricula = new Matricula();
        matricula.setDataMatricula(Instant.now());
        matricula.setCodigo("M1");
        matricula.setStatus("ATIVA");
        matricula.setValor(2500d);
        matricula.setCurso(curso);
        matricula.setAluno(aluno);
        aluno.setMatricula(matricula);

        matricula = matriculaDao.cadastrar(matricula);

        //matriculaDao.delete(matricula);

    }

    private Curso criaCurso(String codigo){
        Curso curso = new Curso();
        curso.setCodigo(codigo);
        curso.setDescricao("Criado no teste Matricula");
        curso.setNome("Criado no teste Matricula");
        return cursoDao.cadastrar(curso);
    }

    private Aluno criarAluno(String s) {
        Aluno aluno = new Aluno();
        aluno.setCodigo(s);
        aluno.setNome("Aluno Teste Matricula");
        aluno.setMatricula(null);
        return alunoDao.cadastrar(aluno);
    }
}