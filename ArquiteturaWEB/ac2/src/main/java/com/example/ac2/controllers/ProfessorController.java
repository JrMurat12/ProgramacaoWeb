package com.example.ac2.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ac2.dtos.ProfessorDTO;
import com.example.ac2.models.Professor;
import com.example.ac2.services.ProfessorService;

@RestController
@RequestMapping("/api/professor")
public class ProfessorController {
    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    public List<Professor> listarTodosProfessores() {
        return professorService.listarTodos();
    }

    @GetMapping("/{id}")
    public Professor listarProfessorPorId(@PathVariable Integer id) {
        return professorService.obterPorId(id);
    }

    @PostMapping
    public Professor criarProfessor(@RequestBody Professor professor) {
        return professorService.salvar(professor);
    }

    @PutMapping("/{id}")
    public Professor atualizarProfessor(@PathVariable Integer id, @RequestBody Professor professor) {
        return professorService.editar(id, professor);
    }

    @DeleteMapping("/{id}")
    public void deletarProfessor(@PathVariable Integer id) {
        professorService.excluir(id);
    }
}


