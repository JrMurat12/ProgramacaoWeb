package ac2teste.ac2teste.services;

import java.util.List;

import ac2teste.ac2teste.models.Curso;


public interface CursoService {
    
    Curso createCurso(Curso curso);
    List<Curso> getAllCursos();
    Curso getCursoById(Long id);
    Curso updateCurso(Long id, Curso curso);
    void deleteCurso(Long id);
    void addProfessorToCurso (Long cursoId, Long professorId);
    void removeProfessorFromCurso (Long cursoId, Long professorId);
    
}
