package com.example.ac2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ac2.models.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    
}
