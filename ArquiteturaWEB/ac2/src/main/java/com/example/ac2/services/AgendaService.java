package com.example.ac2.services;

import java.util.List;

import com.example.ac2.dtos.AgendaDTO;
import com.example.ac2.dtos.DadosAgendaDTO;
import com.example.ac2.models.Agenda;

public interface AgendaService {
    Agenda salvar(AgendaDTO agendaDTO);

    List<AgendaDTO> listarTodos();

    DadosAgendaDTO obterPorId(Long id);

    void excluir(Long id);

    void editar(Long id, AgendaDTO dto);
}

