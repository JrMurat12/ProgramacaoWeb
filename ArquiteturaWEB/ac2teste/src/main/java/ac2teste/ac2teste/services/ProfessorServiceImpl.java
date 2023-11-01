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
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public List<Professor> getAllProfessores() {
        return professorRepository.findAll();
    }

    public Professor getProfessorById(Long id) {
        return professorRepository.findById(id).orElse(null);
    }

    public Professor createProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public Professor updateProfessor(Long id, Professor professor) {
        Professor existingProfessor = professorRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Professor não encontrado com o ID especificado."));
        
        existingProfessor.setNome(professor.getNome());
        existingProfessor.setCpf(professor.getCpf());
        existingProfessor.setRg(professor.getRg());
        existingProfessor.setEndereco(professor.getEndereco());
        existingProfessor.setCelular(professor.getCelular());
        
        return professorRepository.save(existingProfessor);
    }

    public void deleteProfessor(Long id) {
        Professor professor = professorRepository.findById(id)
        .orElseThrow(() -> new RegraNegocioException("Professor não encontrado com o ID especificado."));

        professorRepository.delete(professor);
    }

    public void addCursoToProfessor(Long professorId, Long cursoId) {
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new RegraNegocioException("Professor não encontrado com o ID especificado."));
        
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RegraNegocioException("Curso não encontrado com o ID especificado."));

        professor.getCursos().add(curso);
        
        professorRepository.save(professor);
    }

    public void removeCursoFromProfessor(Long professorId, Long cursoId) {
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new RegraNegocioException("Professor não encontrado com o ID especificado."));
        
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RegraNegocioException("Curso não encontrado com o ID especificado."));

        if (professor.getCursos().contains(curso)) {
            professor.getCursos().remove(curso);
            
            professorRepository.save(professor);
        } else {
            throw new RegraNegocioException("O professor não está associado a este curso.");
        }
    }
}

