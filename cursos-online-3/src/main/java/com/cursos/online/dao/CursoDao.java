package com.cursos.online.dao;

import com.cursos.online.dao.singleton.SingletonEntityManagerFactory;
import com.cursos.online.domain.Curso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

import java.util.Collections;
import java.util.List;

import static jakarta.persistence.Persistence.createEntityManagerFactory;

public class CursoDao implements ICursoDao{

    private final String persistenceName;

    public CursoDao(String persistenceName) {
        this.persistenceName = persistenceName;
    }

    private EntityManager getEntityManager() {
        return SingletonEntityManagerFactory.getEntityManagerFactory(persistenceName).createEntityManager();
    }

    @Override
    public Curso cadastrar(Curso curso) {
        EntityManager entityManager = getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(curso);
        entityManager.getTransaction().commit();

        entityManager.close();

        return curso;
    }

    @Override
    public void delete(Curso curso) {
        Curso deleteCurso;
        EntityManager entityManager = getEntityManager();

        entityManager.getTransaction().begin();
        deleteCurso = entityManager.find(Curso.class, curso.getId());
        entityManager.remove(deleteCurso);
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    @Override
    public Curso buscar(Long id) {
        Curso curso;

        EntityManager entityManager = getEntityManager();

        entityManager.getTransaction().begin();
        curso = entityManager.find(Curso.class, id);
        entityManager.getTransaction().commit();

        entityManager.close();

        return curso;
    }

    @Override
    public List<Curso> buscarTodos() {
        EntityManager entityManager = getEntityManager();
        String jpqlQuery = "SELECT c FROM Curso c";
        try {
            Query query = entityManager.createQuery(jpqlQuery, Curso.class);
            return Collections.unmodifiableList(query.getResultList());
        }  finally{
            entityManager.close();
        }
    }

    @Override
    public Curso atualizar(Long id, Curso curso) {
        Curso saved;
        Curso updated;
        try {
            EntityManager entityManager = getEntityManager();

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
