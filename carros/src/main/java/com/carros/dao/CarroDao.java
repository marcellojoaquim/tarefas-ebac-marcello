package com.carros.dao;

import com.carros.dao.singleton.SingletonManagerFactory;
import com.carros.domain.Carro;
import com.carros.domain.Marca;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;

import java.util.List;

public class CarroDao implements ICarroDao{

    private final String persistenceName;

    public CarroDao(String persistenceName) {
        this.persistenceName = persistenceName;
    }

    private EntityManager getEntityManage() {
        return SingletonManagerFactory.getEntityManagerFactory(persistenceName).createEntityManager();
    }

    @Override
    public Carro cadastrar(Carro carro) {
        EntityManager entityManager = getEntityManage();

        entityManager.getTransaction().begin();
        entityManager.persist(carro);
        entityManager.getTransaction().commit();

        entityManager.close();
        return carro;
    }

    @Override
    public List<Carro> buscarPorMarcaCriteria(Marca marca) {
        EntityManager entityManager = getEntityManage();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Carro> query = builder.createQuery(Carro.class);
        Root<Carro> root = query.from(Carro.class);
        Join<Object, Object> join = root.join("marca", JoinType.INNER);
        query.select(root).where(builder.equal(join.get("marca"), marca));

        TypedQuery<Carro> typedQuery = entityManager.createQuery(query);

        List<Carro> carros = typedQuery.getResultList();

        entityManager.close();

        return carros;
    }

    @Override
    public List<Carro> buscarPorMarca(Marca marca) {
        EntityManager entityManager = getEntityManage();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT c FROM Carro c ");
        stringBuilder.append("INNER JOIN Marca m ON m = c.marca ");
        stringBuilder.append("WHERE m = :marca");

        entityManager.getTransaction().begin();
        TypedQuery<Carro> query = entityManager.createQuery(stringBuilder.toString(), Carro.class);
        query.setParameter("marca", marca);

        return query.getResultList();
    }
}
