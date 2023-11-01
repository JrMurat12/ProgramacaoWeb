package com.example.ac2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ac2.models.Curso;
import com.example.ac2.models.Professor;
import com.example.ac2.repository.ProfessorRepository;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository professorRepository;

    @Autowired
    public ProfessorServiceImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }
    @Override
    public void salvar(Professor professor) {
        professorRepository.save(professor);
    }

    @Override
    public List<Professor> listarTodos() {
        return professorRepository.findAll();
    }

    @Override
    public Professor obterPorId(Long id) {
        return professorRepository.findById(id).orElse(null);
    }

    @Override
    public Professor atualizar(Professor professor, Long id) {
        if (professorRepository.existsById(id)) {
            professor.setId(id);
            return professorRepository.save(professor);
        }
        return null;
    }

    @Override
    public void deletar(Long id) {
        professorRepository.deleteById(id);
    }

    public List<Professor> getProfessoresEspecializados(Curso curso) {
        return professorRepository.findByCursosContaining(curso);
    }

}
