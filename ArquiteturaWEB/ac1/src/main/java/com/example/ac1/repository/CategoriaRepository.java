package com.example.ac1.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ac1.models.Categoria;
import com.example.ac1.models.Produto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class CategoriaRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Categoria inserir(Categoria categoriaProduto) {
        entityManager.persist(categoriaProduto);
        return categoriaProduto;
    }

    @Transactional
    public Categoria editar(Categoria categoriaProduto){
        entityManager.merge(categoriaProduto);
        return categoriaProduto;
    }

    @Transactional
    public void excluir(Categoria categoriaProduto){
        entityManager.remove(categoriaProduto);
    }

    @Transactional
    public void excluir(int id){
        excluir(entityManager.find(Categoria.class, id));
    }

    public List<Categoria > obterTodos() {
        return entityManager.createQuery("from Categoria", Categoria.class).getResultList();
    }

    public List<Produto> obterPorId(int id){
        String jpql = " select c from Categoria c where c.id_categoria = :id_categoria";
        TypedQuery<Produto> query = entityManager.createQuery(jpql, Produto.class);
        query.setParameter("id_categoria", "=" + id);
        return query.getResultList();
    }
}
