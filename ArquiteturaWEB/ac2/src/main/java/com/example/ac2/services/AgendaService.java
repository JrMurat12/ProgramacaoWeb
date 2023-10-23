package com.example.ac2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ac2.dtos.AgendaDTO;
import com.example.ac2.dtos.DadosAgendaDTO;
import com.example.ac2.models.Agenda;
import com.example.ac2.repository.AgendaRepository;

public interface AgendaService {
    Agenda salvar(Agenda agenda);

    List<Agenda> listarTodos();

    Agenda obterPorId(Long id);

    void excluir(Long id);

    Agenda editar(Long id, Agenda agenda);
}

