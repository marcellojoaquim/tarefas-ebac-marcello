package com.cursos.online.dao;

import com.cursos.online.dao.singleton.SingletonEntityManagerFactory;
import com.cursos.online.domain.Matricula;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MatriculaDao implements IMatriculaDao{
    private final String persistenceName;

    public MatriculaDao(String persistenceName) {
        this.persistenceName = persistenceName;
    }

    private EntityManager getEntityManage() {
        return SingletonEntityManagerFactory.getEntityManagerFactory(persistenceName).createEntityManager();
    }

    @Override
    public Matricula cadastrar(Matricula matricula) {

        EntityManager entityManager = getEntityManage();

        entityManager.getTransaction().begin();
        entityManager.persist(matricula);
        entityManager.getTransaction().commit();

        entityManager.close();

        return matricula;
    }

    @Override
    public void delete(Long id, Matricula matricula) {

       EntityManager entityManager = getEntityManage();

        entityManager.getTransaction().begin();
        matricula = entityManager.find(Matricula.class, id);
        entityManager.remove(matricula);
        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
