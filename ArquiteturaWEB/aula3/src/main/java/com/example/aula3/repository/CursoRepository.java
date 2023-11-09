package com.example.aula3.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
// import com.example.aula3.models.CategoriaCurso;
import com.example.aula3.models.Curso;

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
