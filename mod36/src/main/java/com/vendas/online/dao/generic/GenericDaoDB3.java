package com.vendas.online.dao.generic;

import com.vendas.online.dao.Persistente;

import java.io.Serializable;

public abstract class GenericDaoDB3<T extends Persistente, E extends Serializable>
        extends GenericDAO<T, E> {

    public GenericDaoDB3(Class<T> persistenteClass) {
        super(persistenteClass, "Mysql1");
    }
}
