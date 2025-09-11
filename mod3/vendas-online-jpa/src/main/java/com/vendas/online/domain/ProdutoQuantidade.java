package com.vendas.online.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_produto_quantidade")
public class ProdutoQuantidade {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_qtd_seq")
    @SequenceGenerator(name = "produto_qtd_seq", sequenceName = "seq_prod_qtd", initialValue = 1)
    private Long id;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_prod_fk",
            foreignKey = @ForeignKey(name = "fk_produto_qtd"),
            referencedColumnName = "id", nullable = false)
    private Produto produto;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "valorTotal")
    private BigDecimal valorTotal;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_venda_fk",
            foreignKey = @ForeignKey(name = "fk_prod_qtd_venda"),
            referencedColumnName = "id", nullable = false)
    private Venda venda;

    public ProdutoQuantidade() {
        this.quantidade = 0;
        this.valorTotal = BigDecimal.ZERO;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void adicionar(Integer quantidade) {
        this.quantidade += quantidade;
        BigDecimal novoValor = this.produto.getValor().multiply(BigDecimal.valueOf(quantidade));
        BigDecimal novoTotal = this.valorTotal.add(novoValor);
        this.valorTotal = novoTotal;
    }

    public void remover(Integer quantidade) {
        this.quantidade -= quantidade;
        BigDecimal novoValor = this.produto.getValor().multiply(BigDecimal.valueOf(quantidade));
        this.valorTotal = this.valorTotal.subtract(novoValor);
    }


}
