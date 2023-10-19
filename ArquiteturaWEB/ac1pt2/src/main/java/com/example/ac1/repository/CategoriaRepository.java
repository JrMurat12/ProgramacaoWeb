package com.example.ac1.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ac1.models.Categoria;
import com.example.ac1.models.Produto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

public interface CategoriaRepository extends
                    JpaRepository<Categoria, Integer>{

@Query("select cp from tbl_categorias cp left join fetch cp.produtos p " + 
                                                "where cp.idcategoria = :idproduto ")
Categoria findCategoriaFetchProdutosCategoria(@Param("idproduto") Long id);

}

// public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

//     List<Categoria> findBycatnomeStartingWith(String nome);

//     @Query("SELECT c FROM Categoria c LEFT JOIN FETCH c.produtos WHERE c.idcategoria = :categoriaId")
//     Categoria findCategoriaWithProdutosById(@Param("categoriaId") Long categoriaId);

// }
