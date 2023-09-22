package com.example.ac1.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ac1.models.Produto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByprodprecoGreaterThan(Double valor);

    List<Produto> findByprodprecoLessThanEqual(Double valor);

    List<Produto> findByprodnomeStartingWith(String nome);

    @Query("SELECT p FROM Produto p WHERE p.prodpreco > :valor")
    List<Produto> findProdutosComPrecoMaiorQue(@Param("valor") Double valor);

    @Query("SELECT p FROM Produto p WHERE p.prodpreco <= :valor")
    List<Produto> findProdutosComPrecoMenorOuIgualA(@Param("valor") Double valor);

    @Query("SELECT p FROM Produto p WHERE p.prodnome LIKE :nome%")
    List<Produto> findProdutosComNomeQueComecaCom(@Param("nome") String nome);
}

