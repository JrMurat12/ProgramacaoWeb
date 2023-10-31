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

@RestController
@RequestMapping("/agendas")
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    @GetMapping
    public List<Agenda> listarAgendas() {
        return agendaService.listarTodos();
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarAgenda(@RequestBody Agenda novaAgenda) {
        try {
            agendaService.salvar(novaAgenda);
            return new ResponseEntity<>("Agenda criada com sucesso", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao criar a agenda: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{agendaId}")
    public ResponseEntity<Agenda> obterAgenda(@PathVariable Long agendaId) {
        Agenda agenda = agendaService.obterPorId(agendaId);
        if (agenda != null) {
            return new ResponseEntity<>(agenda, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{agendaId}")
    public ResponseEntity<String> atualizarAgenda(@PathVariable Long agendaId, @RequestBody Agenda agendaAtualizada) {
        try {
            Agenda agenda = agendaService.obterPorId(agendaId);
            if (agenda != null) {
                agendaService.atualizar(agendaAtualizada, agendaId);
                return new ResponseEntity<>("Agenda atualizada com sucesso", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Agenda não encontrada", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao atualizar a agenda: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{agendaId}")
    public ResponseEntity<String> excluirAgenda(@PathVariable Long agendaId) {
        try {
            Agenda agenda = agendaService.obterPorId(agendaId);
            if (agenda != null) {
                agendaService.deletar(agendaId);
                return new ResponseEntity<>("Agenda excluída com sucesso", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Agenda não encontrada", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao excluir a agenda: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

