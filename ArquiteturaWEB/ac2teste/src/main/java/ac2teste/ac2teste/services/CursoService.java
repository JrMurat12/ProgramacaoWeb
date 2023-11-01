package ac2teste.ac2teste.services;

import java.util.List;

import ac2teste.ac2teste.dtos.CursoDTO;
import ac2teste.ac2teste.dtos.DadosCursoDTO;
import ac2teste.ac2teste.models.Curso;


public interface CursoService {
    
    void createCurso(Curso curso);
    // List<Curso> getAllCursos(); ---Antigo
    List<CursoDTO> getAllCursos();
    // Curso getCursoById(Long id); ---Antigo
    DadosCursoDTO getCursoById(Long id);
    void updateCurso(Long id, Curso curso);
    void deleteCurso(Long id);
    // void addProfessorToCurso (Long cursoId, Long professorId);
    // void removeProfessorFromCurso (Long cursoId, Long professorId);
    
}
