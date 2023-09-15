package com.example.ac1.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ac1.models.Produto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class ProdutoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Produto inserir (Produto produto){
        entityManager.merge(produto);
        return produto;
    }

    @Transactional
    public Produto editar(Produto produto){
        entityManager.merge(produto);
        return produto;
    }

    @Transactional
    public void excluir(Produto produto){
        entityManager.remove(produto);
    }

    @Transactional
    public void excluir(int id){
        excluir(entityManager.find(Produto.class, id));
    }

    public List<Produto> obterTodos() {
        return entityManager.createQuery("from Produto", Produto.class).getResultList();
    }

    public List<Produto> obterPorId(int id){
        String jpql = " select p from Produto p where p.id_produto = :id_produto";
        TypedQuery<Produto> query = entityManager.createQuery(jpql, Produto.class);
        query.setParameter("id_produto", "=" + id);
        return query.getResultList();
    }
}
