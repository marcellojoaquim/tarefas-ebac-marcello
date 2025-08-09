package com.vendas.online.domain;

import com.vendas.online.dao.Persistente;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_estoque")
public class Estoque implements Persistente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estoque_seq")
    @SequenceGenerator(name = "estoque_seq", sequenceName = "seq_estoque", initialValue = 1)
    private Long id;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_produto_fk",
        foreignKey = @ForeignKey(name = "fk_curso_matricula"),
        referencedColumnName = "id", nullable = false)
    private Produto codigoProduto;

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

    public Produto getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(Produto codigoProduto) {
        this.codigoProduto = codigoProduto;
    }
}
