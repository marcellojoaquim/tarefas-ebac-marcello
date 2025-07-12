package com.cursos.online.dao;

import com.cursos.online.domain.Curso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

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

    @Override
    public void delete(Curso curso) {
        Curso deleteCurso;
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("cursos-online");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        deleteCurso = entityManager.find(Curso.class, curso.getId());
        entityManager.remove(deleteCurso);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public Curso buscar(Long id) {
        Curso curso;

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("cursos-online");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        curso = entityManager.find(Curso.class, id);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return curso;
    }

    @Override
    public List<Curso> buscarTodos() {
        String jpqlQuery = "SELECT c FROM Curso c";

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("cursos-online");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery(jpqlQuery, Curso.class);

        return query.getResultList();
    }
}
