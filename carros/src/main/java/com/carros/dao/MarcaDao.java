package com.carros.dao;

import com.carros.dao.singleton.SingletonManagerFactory;
import com.carros.domain.Marca;
import jakarta.persistence.EntityManager;

public class MarcaDao implements IMarcaDao{

    private final String persistenceName;

    public MarcaDao(String persistenceName) {
        this.persistenceName = persistenceName;
    }

    private EntityManager getEntityManager() {
        return SingletonManagerFactory.getEntityManagerFactory(persistenceName).createEntityManager();
    }

    @Override
    public Marca cadastrar(Marca marca) {
        EntityManager entityManager= getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(marca);
        entityManager.getTransaction().commit();

        entityManager.close();
        return marca;
    }
}
