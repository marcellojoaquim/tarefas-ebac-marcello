package br.com.ebac.demo_mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document("Jogo")
public class Jogo {

    @Id
    private String id;
    private String nome;
    private String distribuidora;
    private String desenvolvedor;
    private String plataforma;

    public Jogo(String nome, String distribuidora, String desenvolvedor, String plataforma) {
        this.nome = nome;
        this.distribuidora = distribuidora;
        this.desenvolvedor = desenvolvedor;
        this.plataforma = plataforma;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDistribuidora() {
        return distribuidora;
    }

    public void setDistribuidora(String distribuidora) {
        this.distribuidora = distribuidora;
    }

    public String getDesenvolvedor() {
        return desenvolvedor;
    }

    public void setDesenvolvedor(String desenvolvedor) {
        this.desenvolvedor = desenvolvedor;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Jogo jogo)) return false;
        return Objects.equals(id, jogo.id) && Objects.equals(nome, jogo.nome) && Objects.equals(distribuidora, jogo.distribuidora) && Objects.equals(desenvolvedor, jogo.desenvolvedor) && Objects.equals(plataforma, jogo.plataforma);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, distribuidora, desenvolvedor, plataforma);
    }
}
