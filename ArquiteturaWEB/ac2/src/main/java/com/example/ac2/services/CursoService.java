package com.example.ac2.services;

import java.util.List;

import com.example.ac2.models.Curso;


public interface CursoService {
    
    Curso createCurso(Curso curso);
    List<Curso> getAllCursos();
    Curso getCursoById(Long id);
    Curso updateCurso(Long id, Curso curso);
    void deleteCurso(Long id);
    Curso addProfessorToCurso (Long cursoId, Long professorId);
    Curso removeProfessorFromCurso (Long cursoId, Long professorId);

}



