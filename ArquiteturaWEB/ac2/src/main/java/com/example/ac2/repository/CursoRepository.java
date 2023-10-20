package com.example.ac2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ac2.models.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}