package com.cursos.online.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_computador")
public class Computador {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "computador_seq")
    @SequenceGenerator(name = "computador_seq", sequenceName = "sq_computador", initialValue = 1)
    private Long id;

    @Column(name = "codigo", length = 10, nullable = false, unique = true)
    private String codigo;

    @Column(name = "descricao", length = 100, nullable = false)
    private String descricao;

    @ManyToMany(mappedBy = "computadores")
    private List<Aluno> alunos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}
