package com.example.ac2.services;

import java.util.List;

import com.example.ac2.models.Curso;


public interface CursoService {
    
    Curso salvar(Curso curso);
    List<Curso> listarTodos();
    Curso obterPorId(Long id);
    Curso atualizar(Curso curso, Long id);
    void deletar(Long id);

}



