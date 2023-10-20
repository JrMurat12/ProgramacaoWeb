package com.example.ac2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.example.ac2.services.ProfessorService;

@RestController
@RequestMapping("/api/agendas")
public class AgendaController {
    @Autowired
    private AgendaService agendaService;
    private ProfessorService professorService;

    @PostMapping
    public ResponseEntity<Agenda> createAgenda(@RequestBody Agenda agenda) {
        Agenda createdAgenda = agendaService.createAgenda(agenda);
        return new ResponseEntity<>(createdAgenda, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Agenda>> getAllAgendas() {
        List<Agenda> agendas = agendaService.getAllAgendas();
        return new ResponseEntity<>(agendas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agenda> getAgendaById(@PathVariable Long id) {
        Agenda agenda = agendaService.getAgendaById(id);
        return new ResponseEntity<>(agenda, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agenda> updateAgenda(@PathVariable Long id, @RequestBody Agenda updatedAgenda) {
        Agenda agenda = agendaService.updateAgenda(id, updatedAgenda);
        return new ResponseEntity<>(agenda, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgenda(@PathVariable Long id) {
        agendaService.deleteAgenda(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/professor/{professorId}")
    public ResponseEntity<List<Agenda>> getAgendaByProfessorId(@PathVariable Long professorId) {
        List<Agenda> agendas = professorService.getAgendaByProfessorId(professorId);
        
        for (Agenda agenda : agendas) {
            System.out.println("Data de Início: " + agenda.getDataInicio());
            System.out.println("Data de Fim: " + agenda.getDataFim());
            System.out.println("Horário de Início: " + agenda.getHorarioInicio());
            System.out.println("Horário de Fim: " + agenda.getHorarioFim());
        }

        return new ResponseEntity<>(agendas, HttpStatus.OK);
    }
}

