package com.vendas.online.dao.generic;

import com.vendas.online.dao.Persistente;

import java.io.Serializable;

public abstract class GenericDaoDB2<T extends Persistente, E extends Serializable>
        extends GenericDAO<T, E> {

    public GenericDaoDB2(Class<T> persistenteClass) {
        super(persistenteClass, "vendas-online-dois");
    }
}
