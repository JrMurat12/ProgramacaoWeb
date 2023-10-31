package com.example.ac2.services;

import java.util.List;

import com.example.ac2.models.Professor;

public interface ProfessorService {
    
    Professor createProfessor(Professor professor);
    List<Professor> getAllProfessores();
    Professor getProfessorById(Long id);
    Professor updateProfessor(Long id, Professor curso);
    void deleteProfessor(Long id);
    Professor addCursoToProfessor (Long professorId, Long cursoId);
    Professor removeCursoFromProfessor (Long professorId, Long cursoId);
    
}


