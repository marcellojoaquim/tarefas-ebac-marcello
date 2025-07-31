package com.carros.dao;

import com.carros.dao.singleton.SingletonManagerFactory;
import com.carros.domain.Acessorio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.Collections;
import java.util.List;

public class AcessorioDao implements IAcessorioDao{

    private final String persistenceName;

    public AcessorioDao(String persistenceName) {
        this.persistenceName = persistenceName;
    }

    private EntityManager getEntityManage() {
        return SingletonManagerFactory.getEntityManagerFactory(persistenceName).createEntityManager();
    }

    @Override
    public Acessorio cadastrar(Acessorio acessorio) {
        EntityManager entityManager = getEntityManage();

        entityManager.getTransaction().begin();
        entityManager.persist(acessorio);
        entityManager.getTransaction().commit();

        entityManager.close();
        return acessorio;
    }

    @Override
    public List<Acessorio> buscarTodos() {
        EntityManager entityManager = getEntityManage();
        String jpql = "SELECT ac FROM Acessorio ac";

        try {
            Query query = entityManager.createQuery(jpql, Acessorio.class);
            return Collections.unmodifiableList(query.getResultList());
        } finally {
            entityManager.close();
        }

    }
}
