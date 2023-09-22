package com.example.ac1.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcategoria;
    @Column(nullable = false)
    private String catnome;
    @OneToMany(mappedBy = "categoriaProduto")
    private List<Produto> produtos;

    public Categoria(Long idcategoria, String catnome, List<Produto> produtos) {
        this.idcategoria = idcategoria;
        this.catnome = catnome;
        this.produtos = produtos;
    }

    public Categoria() {
    }

    public Long getId_categoria() {
        return idcategoria;
    }

    public void setId_categoria(Long idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getCat_nome() {
        return catnome;
    }

    public void setCat_nome(String catnome) {
        this.catnome = catnome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
    
    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

}
