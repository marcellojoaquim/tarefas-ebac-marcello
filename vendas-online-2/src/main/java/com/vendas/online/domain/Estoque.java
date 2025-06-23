package com.vendas.online.domain;

import anotacao.ColunaTabela;
import anotacao.Tabela;
import anotacao.TipoChave;
import com.vendas.online.dao.Persistente;

@Tabela("tb_estoque")
public class Estoque implements Persistente {

    @TipoChave("getId")
    @ColunaTabela(dbName = "id", setJavaName = "setId")
    private Long id;

    @ColunaTabela(dbName = "quantidade", setJavaName = "setQuantidade")
    private Integer quantidade;

    @ColunaTabela(dbName = "codigo_produto", setJavaName = "setCodigoProduto")
    private String codigoProduto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }
}
