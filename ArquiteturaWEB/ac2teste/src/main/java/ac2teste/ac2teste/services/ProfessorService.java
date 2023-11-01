package ac2teste.ac2teste.services;

import java.util.List;

import ac2teste.ac2teste.models.Professor;

public interface ProfessorService {
    
    Professor createProfessor(Professor professor);
    List<Professor> getAllProfessores();
    Professor getProfessorById(Long id);
    Professor updateProfessor(Long id, Professor curso);
    void deleteProfessor(Long id);
    void addCursoToProfessor (Long professorId, Long cursoId);
    void removeCursoFromProfessor (Long professorId, Long cursoId);
    
}
