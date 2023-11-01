package ac2teste.ac2teste.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac2teste.ac2teste.exceptions.RegraNegocioException;
import ac2teste.ac2teste.models.Curso;
import ac2teste.ac2teste.models.Professor;
import ac2teste.ac2teste.repository.CursoRepository;
import ac2teste.ac2teste.repository.ProfessorRepository;

@Service
public class CursoServiceImpl implements CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    public List<Curso> getAllCursos() {
        return cursoRepository.findAll();
    }

    public Curso getCursoById(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    public Curso createCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Curso updateCurso(Long id, Curso curso) {
        Curso existingCurso = cursoRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Curso não encontrado com o ID especificado."));

        existingCurso.setDescricao(curso.getDescricao());
        existingCurso.setCargaHoraria(curso.getCargaHoraria());
        existingCurso.setObjetivos(curso.getObjetivos());
        existingCurso.setEmenta(curso.getEmenta());

        return cursoRepository.save(existingCurso);
    }

    public void deleteCurso(Long id) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Curso não encontrado com o ID especificado."));

        cursoRepository.delete(curso);
    }

    public void addProfessorToCurso(Long cursoId, Long professorId) {
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RegraNegocioException("Curso não encontrado com o ID especificado."));

        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new RegraNegocioException("Professor não encontrado com o ID especificado."));

        curso.getProfessores().add(professor);
        
        cursoRepository.save(curso);
    }

    public void removeProfessorFromCurso(Long cursoId, Long professorId) {
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RegraNegocioException("Curso não encontrado com o ID especificado."));
        
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new RegraNegocioException("Professor não encontrado com o ID especificado."));

        if (curso.getProfessores().contains(professor)) {
            curso.getProfessores().remove(professor);
            
            cursoRepository.save(curso);
        } else {
            throw new RegraNegocioException("O professor não está associado a este curso.");
        }
    }
}




