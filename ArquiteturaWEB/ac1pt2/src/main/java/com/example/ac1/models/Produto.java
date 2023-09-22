package com.example.ac1.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idproduto;
    @Column(length = 200, nullable = false)
    private String prodnome;
    @Column(nullable = false)
    private double prodpreco;
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoriaProduto;

    public Produto(Long idproduto, String prodnome, double prodpreco, Categoria categoriaProduto) {
        this.idproduto = idproduto;
        this.prodnome = prodnome;
        this.prodpreco = prodpreco;
        this.categoriaProduto = categoriaProduto;
    }

    public Produto() {

    }

    public Long getId_produto() {
        return idproduto;
    }

    public void setId_produto(Long idproduto) {
        this.idproduto = idproduto;
    }

    public String getProd_nome() {
        return prodnome;
    }

    public void setProd_nome(String prodnome) {
        this.prodnome = prodnome;
    }

    public double getProd_preco() {
        return prodpreco;
    }

    public void setProd_preco(double prodpreco) {
        this.prodpreco = prodpreco;
    }

    public Categoria getCategoriaProduto() {
        return categoriaProduto;
    }

    public void setCategoriaProduto(Categoria categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }

    @Override
    public String toString() {
        return "Produto [id=" + idproduto + ", nome=" + prodnome + ", quantidade=" + prodpreco + "]";
    }
}
