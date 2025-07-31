package com.carros.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_marca")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "marca_seq")
    @SequenceGenerator(name = "marca_seq", sequenceName = "seq_marca", initialValue = 1)
    private Long id;

    @Column(name = "nome", length = 50, nullable = false, unique = true)
    private String nome;

    @OneToMany(mappedBy = "marca", fetch = FetchType.LAZY, orphanRemoval = true, cascade = {CascadeType.REMOVE})
    private List<Carro> carros;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Carro> getCarro() {
        return carros;
    }

    public void setCarro(List<Carro> carros) {
        this.carros = carros;
    }
}
