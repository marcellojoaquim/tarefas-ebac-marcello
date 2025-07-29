package com.cursos.online.dao;

import com.cursos.online.domain.Curso;
import com.cursos.online.domain.Matricula;

import java.util.List;

public interface IMatriculaDao {

    Matricula cadastrar(Matricula matricula);
    void delete(Long id, Matricula matricula);
    Matricula buscarPorCodigoCurso(String codigoCurso);
    Matricula buscarPorCurso(Curso curso);
    Matricula buscarPorId(Long id);
    Matricula buscarPorCodigoCursoCriteria(String codigoCurso);
    List<Matricula> buscarTodosCriteria();
    //Matricula atualizar(Matricula matricula);

}
