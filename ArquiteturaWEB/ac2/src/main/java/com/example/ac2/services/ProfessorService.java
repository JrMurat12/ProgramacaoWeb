package com.example.ac2.services;

import java.util.List;

import com.example.ac2.models.Professor;

public interface ProfessorService {
    
    void salvar(Professor professor);
    List<Professor> listarTodos();
    Professor obterPorId(Long id);
    Professor atualizar(Professor professor, Long id);
    void deletar(Long id);
    
}


