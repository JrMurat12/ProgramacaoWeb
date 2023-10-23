package com.example.ac2.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Agenda> listarTodasAgendas() {
        return agendaService.listarTodos();
    }

    @GetMapping("/{id}")
    public Agenda listarAgendaPorID(@PathVariable Long id) {
        return agendaService.obterPorId(id);
    }

    @PostMapping
    public Agenda salvarAgenda(@RequestBody Agenda agenda) {
        return agendaService.salvar(agenda);
    }

    @PutMapping("/{id}")
    public Agenda atualizarAgenda(@PathVariable Long id, @RequestBody Agenda agenda) {
        return agendaService.editar(id, agenda);
    }

    @DeleteMapping("/{id}")
    public void deletarAgenda(@PathVariable Long id) {
        agendaService.excluir(id);
    }
}

