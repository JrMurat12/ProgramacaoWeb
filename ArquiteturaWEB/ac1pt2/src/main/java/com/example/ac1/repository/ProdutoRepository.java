package com.example.ac1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ac1.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}

// public interface ProdutoRepository extends JpaRepository<Produto, Long> {
//     List<Produto> findByprodprecoGreaterThan(Double valor);

//     List<Produto> findByprodprecoLessThanEqual(Double valor);

//     List<Produto> findByprodnomeStartingWith(String nome);

//     @Query("SELECT p FROM Produto p WHERE p.prodpreco > :valor")
//     List<Produto> findProdutosComPrecoMaiorQue(@Param("valor") Double valor);

//     @Query("SELECT p FROM Produto p WHERE p.prodpreco <= :valor")
//     List<Produto> findProdutosComPrecoMenorOuIgualA(@Param("valor") Double valor);

//     @Query("SELECT p FROM Produto p WHERE p.prodnome LIKE :nome%")
//     List<Produto> findProdutosComNomeQueComecaCom(@Param("nome") String nome);
// }

