package com.cursos.online.dao;

import com.cursos.online.domain.Matricula;

public interface IMatriculaDao {

    Matricula cadastrar(Matricula matricula);
    void delete(Long id, Matricula matricula);
    //Matricula atualizar(Matricula matricula);
}
