package com.example.ac2.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ac2.models.Agenda;
import com.example.ac2.services.AgendaService;

@RestController
@RequestMapping("/api/agenda")
public class AgendaController {
    private final AgendaService agendaService;

    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @GetMapping
    public List<Agenda> getAllAgendas() {
        return agendaService.getAllAgendas();
    }

    @GetMapping("/{id}")
    public Agenda getAgendaById(@PathVariable Long id) {
        return agendaService.getAgendaById(id);
    }

    @PostMapping
    public Agenda createAgenda(@RequestBody Agenda agenda) {
        return agendaService.createAgenda(agenda);
    }

    @PutMapping("/{id}")
    public Agenda updatAgenda(@PathVariable Long id, @RequestBody Agenda agenda) {
        return agendaService.updateAgenda(agenda, id);
    }

    @DeleteMapping("/{id}")
    public void deleteAgenda(@PathVariable Long id) {
        agendaService.deleteAgenda(id);
    }
}

