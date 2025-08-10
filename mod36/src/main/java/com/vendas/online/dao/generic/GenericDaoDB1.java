package com.vendas.online.dao.generic;

import com.vendas.online.dao.Persistente;

import java.io.Serializable;

public abstract class GenericDaoDB1<T extends Persistente, E extends Serializable>
    extends GenericDAO<T, E> {

    public GenericDaoDB1(Class<T> persistenteClass){
        super(persistenteClass, "vendas-online");
    }
}
