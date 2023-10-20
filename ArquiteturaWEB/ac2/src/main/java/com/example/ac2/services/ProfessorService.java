package com.example.ac2.services;

import java.util.List;

import com.example.ac2.dtos.DadosProfessorDTO;
import com.example.ac2.dtos.ProfessorDTO;
import com.example.ac2.models.Professor;

public interface ProfessorService {
    Professor salvar(ProfessorDTO professorDTO);

    // List<ProfessorDTO> listarTodos();

    // DadosProfessorDTO obterPorId(Integer id);

    // void excluir(Integer id);

    // void editar(Integer id, ProfessorDTO dto);
}

