package ac2teste.ac2teste.services;

import java.util.List;

import ac2teste.ac2teste.dtos.CursoDTO;
import ac2teste.ac2teste.dtos.DadosCursoDTO;
import ac2teste.ac2teste.models.Curso;


public interface CursoService {
    
    void createCurso(Curso curso);
    List<CursoDTO> getAllCursos();
    DadosCursoDTO getCursoById(Long id);
    void updateCurso(Long id, Curso curso);
    void deleteCurso(Long id);
    
}
