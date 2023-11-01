package ac2teste.ac2teste.services;

import java.util.List;

import ac2teste.ac2teste.dtos.DadosProfessorDTO;
import ac2teste.ac2teste.dtos.ProfessorDTO;
import ac2teste.ac2teste.models.Professor;

public interface ProfessorService {
    
    void createProfessor(Professor professor);
    // List<Professor> getAllProfessores(); ---Antigo
    List<ProfessorDTO> getAllProfessores();
    DadosProfessorDTO getProfessorById(Long id);
    // Professor getProfessorById(Long id); ---Antigo
    void updateProfessor(Long id, Professor curso);
    void deleteProfessor(Long id);
    void addCursoToProfessor (Long professorId, Long cursoId);
    void removeCursoFromProfessor (Long professorId, Long cursoId);
    
}
