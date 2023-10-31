package com.example.ac2.services;

import java.util.List;

import com.example.ac2.models.Agenda;

public interface AgendaService {

    Agenda createAgenda(Agenda agenda);
    List<Agenda> getAllAgendas();
    Agenda getAgendaById(Long id);
    Agenda updateAgenda(Agenda agenda, Long id);
    void deleteAgenda(Long id);

}

