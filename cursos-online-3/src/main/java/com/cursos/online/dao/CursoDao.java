package com.cursos.online.dao;

import com.cursos.online.domain.Curso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

import java.util.Collections;
import java.util.List;

import static jakarta.persistence.Persistence.createEntityManagerFactory;

public class CursoDao implements ICursoDao{

    @Override
    public Curso cadastrar(Curso curso) {

        EntityManagerFactory entityManagerFactory =
                createEntityManagerFactory("cursos-online");
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
                createEntityManagerFactory("cursos-online");
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
                createEntityManagerFactory("cursos-online");
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

        EntityManager entityManager;
        try (EntityManagerFactory entityManagerFactory = createEntityManagerFactory("cursos-online")) {
            entityManager = entityManagerFactory.createEntityManager();
        }

        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery(jpqlQuery, Curso.class);

        return Collections.unmodifiableList(query.getResultList());
    }

    @Override
    public Curso atualizar(Long id, Curso curso) {
        Curso saved;
        Curso updated;
        try {
            EntityManager entityManager;
            EntityManagerFactory entityManagerFactory = createEntityManagerFactory("cursos-online");
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            saved = buscar(id);
            saved.setNome(curso.getNome());
            saved.setDescricao(curso.getDescricao());
            saved.setCodigo(curso.getCodigo());

            updated = entityManager.merge(saved);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return updated;
    }


}
