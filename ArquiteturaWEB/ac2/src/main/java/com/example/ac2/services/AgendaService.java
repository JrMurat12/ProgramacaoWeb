package com.example.ac2.services;

import java.util.List;

import com.example.ac2.models.Agenda;

public interface AgendaService {

    Agenda salvar(Agenda agenda);
    List<Agenda> listarTodos();
    Agenda obterPorId(Long id);
    Agenda atualizar(Agenda agenda, Long id);
    void deletar(Long id);
    boolean professorIsAvailable(Agenda novaAgenda);

}

