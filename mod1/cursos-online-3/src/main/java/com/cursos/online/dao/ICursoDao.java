package com.cursos.online.dao;

import com.cursos.online.domain.Curso;

import java.util.List;

public interface ICursoDao {

    Curso cadastrar(Curso curso);
    void delete(Curso curso);
    Curso buscar(Long id);
    List<Curso> buscarTodos();
    Curso atualizar(Long id, Curso curso);

}
