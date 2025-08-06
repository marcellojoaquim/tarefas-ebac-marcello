package com.vendas.online.domain;

import com.vendas.online.dao.Persistente;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "TB_PRODUTO")
public class Produto implements Persistente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_seq")
    @SequenceGenerator(name = "produto_seq", sequenceName = "seq_produto", initialValue = 1)
    private Long id;

    @Column(name = "codigo", nullable = false, length = 50)
    private String codigo;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "descricao", length = 150)
    private String descricao;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    @Column(name = "fabricante", length = 50)
    private String fabricante;

    @OneToOne(mappedBy = "codigoProduto", cascade = CascadeType.ALL, orphanRemoval = true)
    private Estoque estoque;

    @OneToOne(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
    private ProdutoQuantidade produtoQuantidade;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public ProdutoQuantidade getProdutoQuantidade() {
        return produtoQuantidade;
    }

    public void setProdutoQuantidade(ProdutoQuantidade produtoQuantidade) {
        this.produtoQuantidade = produtoQuantidade;
    }
}
