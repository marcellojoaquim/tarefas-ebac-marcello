package com.cursos.online.dao;

import com.cursos.online.dao.singleton.SingletonEntityManagerFactory;
import com.cursos.online.domain.Computador;
import jakarta.persistence.EntityManager;

public class ComputadorDao implements IComputadorDao{

    private final String persistenceName;

    public ComputadorDao(String persistenceName) {
        this.persistenceName = persistenceName;
    }

    private EntityManager getEntityManager() {
        return SingletonEntityManagerFactory.getEntityManagerFactory(persistenceName).createEntityManager();
    }

    @Override
    public Computador cadastrar(Computador computador) {

        EntityManager entityManager = getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(computador);
        entityManager.getTransaction().commit();

        entityManager.close();

        return computador;
    }
}
