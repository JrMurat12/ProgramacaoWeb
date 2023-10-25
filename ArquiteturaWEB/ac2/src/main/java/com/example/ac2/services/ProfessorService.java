package com.example.ac2.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ac2.dtos.DadosProfessorDTO;
import com.example.ac2.dtos.ProfessorDTO;
import com.example.ac2.models.Curso;
import com.example.ac2.models.Professor;
import com.example.ac2.repository.CursoRepository;
import com.example.ac2.repository.ProfessorRepository;

@Service
public class ProfessorService {
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
                .orElseThrow(() -> new RuntimeException("Professor não encontrado com o ID especificado."));
        
        existingProfessor.setNome(professor.getNome());
        existingProfessor.setCpf(professor.getCpf());
        existingProfessor.setRg(professor.getRg());
        existingProfessor.setEndereco(professor.getEndereco());
        existingProfessor.setCelular(professor.getCelular());
        
        return professorRepository.save(existingProfessor);
    }

    public void deleteProfessor(Long id) {
        Professor professor = professorRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Professor não encontrado com o ID especificado."));

        professorRepository.delete(professor);
    }

    public Professor addCursoToProfessor(Long professorId, Long cursoId) {
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado com o ID especificado."));
        
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado com o ID especificado."));

        professor.getCursos().add(curso);
        
        return professorRepository.save(professor);
    }

    public Professor removeCursoFromProfessor(Long professorId, Long cursoId) {
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado com o ID especificado."));
        
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado com o ID especificado."));

        if (professor.getCursos().contains(curso)) {
            professor.getCursos().remove(curso);
            
            return professorRepository.save(professor);
        } else {
            throw new RuntimeException("O professor não está associado a este curso.");
        }
    }
}


