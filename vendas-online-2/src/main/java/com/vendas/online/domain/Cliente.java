package com.vendas.online.domain;

import anotacao.ColunaTabela;
import anotacao.Tabela;
import anotacao.TipoChave;
import com.vendas.online.dao.Persistente;

@Tabela("TB_CLIENTE")
public class Cliente implements Persistente {

    @ColunaTabela(dbName = "id", setJavaName = "setId")
    private Long id;

    @ColunaTabela(dbName = "nome", setJavaName = "setNome")
    private String nome;

    @ColunaTabela(dbName = "sobrenome", setJavaName = "setSobreNome")
    private String sobreNome;

    @TipoChave("getCpf")
    @ColunaTabela(dbName = "cpf", setJavaName = "setCpf")
    private Long cpf;

    @ColunaTabela(dbName = "tel", setJavaName = "setTel")
    private Long tel;

    @ColunaTabela(dbName = "endereco", setJavaName = "setEnd")
    private String end;

    @ColunaTabela(dbName = "numero", setJavaName = "setNumero")
    private Integer numero;

    @ColunaTabela(dbName = "cidade", setJavaName = "setCidade")
    private String cidade;

    @ColunaTabela(dbName = "estado", setJavaName = "setEstado")
    private String estado;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public Long getCpf() {
        return cpf;
    }
    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }
    public Long getTel() {
        return tel;
    }
    public void setTel(Long tel) {
        this.tel = tel;
    }
    public String getEnd() {
        return end;
    }
    public void setEnd(String end) {
        this.end = end;
    }
    public Integer getNumero() {
        return numero;
    }
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
