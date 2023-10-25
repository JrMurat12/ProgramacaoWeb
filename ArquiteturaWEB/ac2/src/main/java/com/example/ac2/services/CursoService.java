package com.example.ac2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ac2.dtos.CursoDTO;
import com.example.ac2.dtos.DadosCursoDTO;
import com.example.ac2.models.Curso;
import com.example.ac2.models.Professor;
import com.example.ac2.repository.CursoRepository;
import com.example.ac2.repository.ProfessorRepository;

@Service
public class CursoService {
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
                .orElseThrow(() -> new RuntimeException("Curso não encontrado com o ID especificado."));

        existingCurso.setDescricao(curso.getDescricao());
        existingCurso.setCargaHoraria(curso.getCargaHoraria());
        existingCurso.setObjetivos(curso.getObjetivos());
        existingCurso.setEmenta(curso.getEmenta());

        return cursoRepository.save(existingCurso);
    }

    public void deleteCurso(Long id) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado com o ID especificado."));

        cursoRepository.delete(curso);
    }

    public Curso addProfessorToCurso(Long cursoId, Long professorId) {
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado com o ID especificado."));

        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado com o ID especificado."));

        curso.getProfessores().add(professor);
        
        return cursoRepository.save(curso);
    }

    public Curso removeProfessorFromCurso(Long cursoId, Long professorId) {
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado com o ID especificado."));
        
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado com o ID especificado."));

        if (curso.getProfessores().contains(professor)) {
            curso.getProfessores().remove(professor);
            
            return cursoRepository.save(curso);
        } else {
            throw new RuntimeException("O professor não está associado a este curso.");
        }
    }
}



