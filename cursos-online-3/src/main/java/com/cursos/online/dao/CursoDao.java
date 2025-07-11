package com.cursos.online.dao;

import com.cursos.online.domain.Curso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CursoDao implements ICursoDao{

    @Override
    public Curso cadastrar(Curso curso) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("cursos-online");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(curso);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return curso;
    }
}
