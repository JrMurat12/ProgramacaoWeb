package com.example.ac1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ac1.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}

// public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

//     List<Categoria> findBycatnomeStartingWith(String nome);

//     @Query("SELECT c FROM Categoria c LEFT JOIN FETCH c.produtos WHERE c.idcategoria = :categoriaId")
//     Categoria findCategoriaWithProdutosById(@Param("categoriaId") Long categoriaId);

// }
