package com.example.ac2.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ac2.dtos.DadosProfessorDTO;
import com.example.ac2.dtos.ProfessorDTO;
import com.example.ac2.models.Professor;
import com.example.ac2.repository.ProfessorRepository;

public interface ProfessorService {
    Professor salvar(Professor professor);

    List<Professor> listarTodos();

    Professor obterPorId(Integer id);

    void excluir(Integer id);

    Professor editar(Integer id, Professor professor);

    // public List<ProfessorDTO> listarPorCategorias(List<Integer> cursoProfessorId) {
    // List<ProfessorDTO> professores = professorRepository.findAll().stream()
    //         .filter(p -> cursoProfessorId.contains(
    //                 p.getCursos() == null ? 0 : p.getCursos().getId()))
    //         .map((Professor p) -> {
    //             return ProfessorDTO.builder()
    //                     .id(p.getId())
    //                     .nome(p.getNome())
    //                     .rg(p.getRg())
    //                     .cursoProfessorId(
    //                             p.getCursos() == null ? 0
    //                                     : p.getCursos())
    //                     .build();
    //         })
    //         .collect(Collectors.toList());
    // return professores;
    // }
}

