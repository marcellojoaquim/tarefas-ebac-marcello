package com.cursos.online.dao;

import com.cursos.online.domain.Matricula;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MatriculaDao implements IMatriculaDao{

    @Override
    public Matricula cadastrar(Matricula matricula) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("cursos-online");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(matricula);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return matricula;
    }

    @Override
    public void delete(Matricula matricula) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("cursos-online");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        matricula = entityManager.merge(matricula);
        entityManager.remove(matricula);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
