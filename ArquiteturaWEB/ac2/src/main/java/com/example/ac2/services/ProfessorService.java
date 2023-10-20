package com.example.ac2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ac2.models.Agenda;
import com.example.ac2.models.Curso;
import com.example.ac2.models.Professor;
import com.example.ac2.repository.AgendaRepository;
import com.example.ac2.repository.CursoRepository;
import com.example.ac2.repository.ProfessorRepository;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;
    private CursoRepository cursoRepository;
    private AgendaRepository agendaRepository;

    public List<Professor> getAllProfessores() {
        return professorRepository.findAll();
    }

    public Professor getProfessorById(Long id) {
        return professorRepository.findById(id).orElse(null);
    }

    public Professor createProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public Professor updateProfessor(Long id, Professor updatedProfessor) {
        Professor existingProfessor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado com o ID especificado."));
        
        existingProfessor.setNome(updatedProfessor.getNome());
        existingProfessor.setCpf(updatedProfessor.getCpf());
        existingProfessor.setRg(updatedProfessor.getRg());
        existingProfessor.setEndereco(updatedProfessor.getEndereco());
        existingProfessor.setCelular(updatedProfessor.getCelular());
        
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

    public List<Agenda> getAgendaByProfessorId(Long professorId) {
        return agendaRepository.findByProfessorId(professorId);
    }
}

