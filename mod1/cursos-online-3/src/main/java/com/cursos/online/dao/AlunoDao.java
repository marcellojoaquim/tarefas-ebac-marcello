package com.cursos.online.dao;

import com.cursos.online.dao.singleton.SingletonEntityManagerFactory;
import com.cursos.online.domain.Aluno;
import jakarta.persistence.EntityManager;

public class AlunoDao implements IAlunoDao {
    private final String persistenceName;

    public AlunoDao(String persistenceName) {
        this.persistenceName = persistenceName;
    }

    private EntityManager getEntityManage() {
        return SingletonEntityManagerFactory.getEntityManagerFactory(persistenceName).createEntityManager();
    }

    @Override
    public Aluno cadastrar(Aluno aluno) {
        EntityManager entityManager = getEntityManage();

        entityManager.getTransaction().begin();
        entityManager.persist(aluno);
        entityManager.getTransaction().commit();

        entityManager.close();
        return aluno;
    }
}
