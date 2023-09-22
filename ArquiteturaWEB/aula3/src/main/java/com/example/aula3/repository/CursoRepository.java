package com.example.aula3.repository;

import java.util.List;

import javax.swing.text.html.parser.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.aula3.models.CategoriaCurso;
// import com.example.aula3.models.CategoriaCurso;
import com.example.aula3.models.Curso;

import jakarta.persistence.EntityManager;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    List<Curso> findByNomeLike(String nome);
}



// @Repository
// public class CursoRepository {
//     @Autowired
//     private EntityManager entityManager;

//     @Transactional
//     public Curso inserir (Curso curso){
//         entityManager.merge(curso);
//         return curso;
//     }

//     @Transactional
//     public Curso editar(Curso curso){
//         entityManager.merge(curso);
//         return curso;
//     }

//     @Transactional
//     public void excluir(Curso curso){
//         entityManager.remove(curso);
//     }

//     @Transactional
//     public void excluir(int id){
//         excluir(entityManager.find(Curso.class, id));
//     }

//     public List<Curso> obterTodos() {
//         return entityManager.createQuery("from Curso", Curso.class).getResultList();
//     }

//     public List<Curso> obterPorNome(String nome){
//         String jpql = " select c from Curso c where c.nome like :nome";
//         TypedQuery<Curso> query = entityManager.createQuery(jpql, Curso.class);
//         query.setParameter("nome", "%" + nome + "%");
//         return query.getResultList();
//     }

// }
