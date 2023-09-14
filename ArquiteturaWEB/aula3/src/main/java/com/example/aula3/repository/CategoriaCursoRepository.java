package com.example.aula3.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.aula3.models.CategoriaCurso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.transaction.Transactional;

@Repository
public class CategoriaCursoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public CategoriaCurso inserir(CategoriaCurso categoriaCursocategoriaCurso) {
        entityManager.persist(categoriaCursocategoriaCurso);
        return categoriaCursocategoriaCurso;
    }

    public List<CategoriaCurso > obterTodos() {
        return entityManager.createQuery("from CategoriaCursoCategoriaCurso", CategoriaCurso.class).getResultList();
    }

}
