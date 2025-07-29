package com.cursos.online.dao;

import com.cursos.online.dao.singleton.SingletonEntityManagerFactory;
import com.cursos.online.domain.Curso;
import com.cursos.online.domain.Matricula;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;

import java.util.List;

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

    @Override
    public Matricula buscarPorCodigoCurso(String codigoCurso) {
        EntityManager entityManager = getEntityManage();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT m FROM Matricula m ");
        stringBuilder.append("INNER JOIN Curso c ON c = m.curso ");
        stringBuilder.append("WHERE c.codigo = :codigoCurso");

        entityManager.getTransaction().begin();
        TypedQuery<Matricula> query = entityManager.createQuery(stringBuilder.toString(), Matricula.class);
        query.setParameter("codigoCurso", codigoCurso);
        Matricula matricula = query.getSingleResult();

        entityManager.close();
        return matricula;
    }

    @Override
    public Matricula buscarPorCurso(Curso curso) {
        EntityManager entityManager = getEntityManage();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT m FROM Matricula m ");
        stringBuilder.append("INNER JOIN Curso c ON c = m.curso ");
        stringBuilder.append("WHERE c = :curso");

        entityManager.getTransaction().begin();
        TypedQuery<Matricula> query = entityManager.createQuery(stringBuilder.toString(), Matricula.class);
        query.setParameter("curso", curso);
        Matricula matricula = query.getSingleResult();

        entityManager.close();
        return matricula;
    }

    @Override
    public Matricula buscarPorId(Long id) {
        Matricula matricula;

        EntityManager entityManager = getEntityManage();

        entityManager.getTransaction().begin();
        matricula = entityManager.find(Matricula.class, id);
        entityManager.close();

        return matricula;
    }

    @Override
    public Matricula buscarPorCodigoCursoCriteria(String codigoCurso) {
        EntityManager entityManager = getEntityManage();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Matricula> query = builder.createQuery(Matricula.class);
        Root<Matricula> root = query.from(Matricula.class);
        Join<Object, Object> join = root.join("curso", JoinType.INNER);
        query.select(root).where(builder.equal(join.get("codigo"), codigoCurso));

        TypedQuery<Matricula> typedQuery =
                entityManager.createQuery(query);

        Matricula matricula = typedQuery.getSingleResult();

        entityManager.close();
        return matricula;
    }

    @Override
    public List<Matricula> buscarTodosCriteria() {

        EntityManager entityManager = getEntityManage();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Matricula> query = builder.createQuery(Matricula.class);
        Root<Matricula> root = query.from(Matricula.class);

        query.select(root);

        TypedQuery<Matricula> typedQuery =
                entityManager.createQuery(query);
        List<Matricula> list = typedQuery.getResultList();

        entityManager.close();

        return list;
    }
}
