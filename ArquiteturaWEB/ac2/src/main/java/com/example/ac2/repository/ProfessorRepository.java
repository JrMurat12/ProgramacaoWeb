package com.example.ac2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ac2.models.Curso;
import com.example.ac2.models.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    @Query("SELECT p FROM Professor p JOIN p.cursos c WHERE c = :curso")
    List<Professor> findByCursosContaining(@Param("curso") Curso curso);
}
