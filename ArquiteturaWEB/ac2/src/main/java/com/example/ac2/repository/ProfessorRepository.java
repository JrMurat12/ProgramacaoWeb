package com.example.ac2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ac2.models.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

}
