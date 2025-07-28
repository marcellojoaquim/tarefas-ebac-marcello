package com.cursos.online.dao;

import com.cursos.online.domain.Curso;
import com.cursos.online.domain.Matricula;

public interface IMatriculaDao {

    Matricula cadastrar(Matricula matricula);
    void delete(Long id, Matricula matricula);
    Matricula buscarPorCodigoCurso(String codigoCurso);
    Matricula buscarPorCurso(Curso curso);
    Matricula buscarPorId(Long id);
    //Matricula atualizar(Matricula matricula);

}
