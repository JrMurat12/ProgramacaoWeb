package com.example.ac2.services;

import java.util.List;

import com.example.ac2.dtos.CursoDTO;
import com.example.ac2.dtos.DadosCursoDTO;
import com.example.ac2.models.Curso;

public interface CursoService {
    Curso salvar(CursoDTO cursoDTO);

    List<CursoDTO> listarTodos();

    DadosCursoDTO obterPorId(Integer id);

    void excluir(Integer id);

    void editar(Integer id, CursoDTO dto);
}


