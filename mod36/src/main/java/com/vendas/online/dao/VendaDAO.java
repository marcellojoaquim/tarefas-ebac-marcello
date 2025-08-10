package com.vendas.online.dao;

import com.vendas.online.dao.generic.GenericDAO;
import com.vendas.online.dao.generic.GenericDaoDB1;
import com.vendas.online.domain.Venda;
import com.vendas.online.exceptions.DAOException;
import com.vendas.online.exceptions.TipoChaveNaoEncontradaException;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;


public class VendaDAO extends GenericDaoDB1<Venda, String> implements IVendasDAO {

    public VendaDAO() {
        super(Venda.class);
    }

    @Override
    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
        super.alterar(venda);
    }

    @Override
    public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
        super.alterar(venda);
    }

    @Override
    public Venda consultarComCollection(Long id) {
        openConnection();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Venda> query = builder.createQuery(Venda.class);
        Root<Venda> root = query.from(Venda.class);
        root.fetch("cliente");
        root.fetch("produtos");
        query.select(root).where(builder.equal(root.get("id"), id));
        TypedQuery<Venda> tpQuery =
                entityManager.createQuery(query);
        Venda venda = tpQuery.getSingleResult();
        closeConnection();
        return venda;
    }
}
