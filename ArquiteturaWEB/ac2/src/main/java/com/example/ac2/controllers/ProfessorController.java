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
    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public List<Professor> getAllProfessores() {
        return professorService.getAllProfessores();
    }

    @GetMapping("/{id}")
    public Professor getProfessorById(@PathVariable Long id) {
        return professorService.getProfessorById(id);
    }

    @PostMapping
    public Professor createProfessor(@RequestBody Professor professor) {
        return professorService.createProfessor(professor);
    }

    @PutMapping("/{id}")
    public Professor updateProfessor(@PathVariable Long id, @RequestBody Professor professor) {
        return professorService.updateProfessor(id, professor);
    }

    @DeleteMapping("/{id}")
    public void deleteProfessor(@PathVariable Long id) {
        professorService.deleteProfessor(id);
    }
    
    @PostMapping("/{professorId}/cursos/{cursoId}")
    public Professor addCursoToProfessor(
            @PathVariable Long professorId, @PathVariable Long cursoId) {
        return professorService.addCursoToProfessor(professorId, cursoId);
    }
    
    @DeleteMapping("/{professorId}/cursos/{cursoId}")
    public Professor removeCursoFromProfessor(
            @PathVariable Long professorId, @PathVariable Long cursoId) {
        return professorService.removeCursoFromProfessor(professorId, cursoId);
    }
}


