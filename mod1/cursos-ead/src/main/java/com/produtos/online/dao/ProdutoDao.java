package com.produtos.online.dao;

import com.produtos.online.dao.exceptions.NotFoundException;
import com.produtos.online.dao.singleton.SingletonEntityManagerFactory;
import com.produtos.online.domain.Produto;
import jakarta.persistence.*;

import java.util.Collections;
import java.util.List;

public class ProdutoDao implements IProdutoDao{

    private final String persistenceName;

    public ProdutoDao(String persistenceName) {
        this.persistenceName = persistenceName;
    }

    private EntityManager getEntityManager() {
        return SingletonEntityManagerFactory.getEntityManagerFactory(persistenceName).createEntityManager();
    }

    @Override
    public Produto cadastrar(Produto produto) {
        EntityManager entityManager = getEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(produto);
            entityManager.getTransaction().commit();
            return produto;
        } catch (Exception e) {
            if(entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("Erro ao salvar: "+e.getMessage(), e);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void delete(Long id) throws NotFoundException {
        EntityManager entityManager = getEntityManager();

        try {
            entityManager.getTransaction().begin();
            Produto produto = entityManager.find(Produto.class, id);
            if(produto != null){
                entityManager.remove(produto);
            } else {
                throw new NotFoundException("Produto não encontrado");
            }
            entityManager.getTransaction().commit();
        } catch (NotFoundException e) {
            if(entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("Erro ao deletar: "+e.getMessage(), e);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Produto buscar(Long id) throws NotFoundException {
        EntityManager entityManager = getEntityManager();
        try {
            Produto produto = entityManager.find(Produto.class, id);
            if(produto != null){
                return produto;
            } else {
                throw new NotFoundException("Produto não encontrado");
            }
        }finally {
            entityManager.close();
        }
    }

    @Override
    public Produto buscarPorCodigo(String codigo)  throws NotFoundException{
        EntityManager entityManager = getEntityManager();
        try {
            Produto produto = entityManager.find(Produto.class, codigo);
            if(produto != null) {
                return produto;
            } else {
                throw  new NotFoundException("Produto nao encontrado.");
            }
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Produto> buscarTodos() {
        String jpqlQuery = "SELECT p FROM Produto p";
        try (EntityManager entityManager = getEntityManager()) {
            Query query = entityManager.createQuery(jpqlQuery, Produto.class);
            return Collections.unmodifiableList(query.getResultList());
        }
    }

    @Override
    public Produto atualiar(Long id, Produto produto) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            Produto saved = entityManager.find(Produto.class, id);

            if(saved == null){
                throw new NotFoundException("Produto nao encontrado");
            }

            saved.setNome(produto.getNome());
            saved.setDescricao(produto.getDescricao());
            saved.setCodigo(produto.getCodigo());

            Produto updated = entityManager.merge(saved);
            entityManager.getTransaction().commit();
            return updated;
        } catch (Exception e) {
            if(entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("Error ao atualizar: "+e.getMessage(), e);
        } finally {
            entityManager.close();
        }
    }
}
