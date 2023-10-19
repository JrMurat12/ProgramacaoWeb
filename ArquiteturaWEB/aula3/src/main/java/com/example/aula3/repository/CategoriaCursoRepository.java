package com.example.aula3.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;
import com.example.aula3.models.CategoriaCurso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.transaction.Transactional;

public interface CategoriaCursoRepository extends
                    JpaRepository<CategoriaCurso, Integer>{

@Query("select cc from CategoriaCurso cc left join fetch cc.cursos c " +
                                                "where cc.id = :id ")
CategoriaCurso findCategoriaCursoFetchCursos(@Param("id") Long id);

}



// @Repository
// public class CategoriaCursoRepository {
//     @Autowired
//     private EntityManager entityManager;

//     @Transactional
//     public CategoriaCurso inserir(CategoriaCurso categoriaCursocategoriaCurso) {
//         entityManager.persist(categoriaCursocategoriaCurso);
//         return categoriaCursocategoriaCurso;
//     }

//     public List<CategoriaCurso > obterTodos() {
//         return entityManager.createQuery("from CategoriaCursoCategoriaCurso", CategoriaCurso.class).getResultList();
//     }

// }
