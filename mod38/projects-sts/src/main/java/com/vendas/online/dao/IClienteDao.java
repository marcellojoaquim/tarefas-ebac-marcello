package com.vendas.online.dao;



import javax.enterprise.context.ApplicationScoped;

import com.vendas.online.dao.generic.IGenericDao;
import com.vendas.online.domain.Cliente;

@ApplicationScoped
public interface IClienteDao extends IGenericDao<Cliente, Long>{

}
