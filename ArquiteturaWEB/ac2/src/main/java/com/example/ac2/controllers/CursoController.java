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

import com.example.ac2.models.Curso;
import com.example.ac2.services.CursoService;

@RestController
@RequestMapping("/api/curso")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<Curso> getAllCursos() {
        return cursoService.getAllCursos();
    }

    @GetMapping("/{id}")
    public Curso getCursoById(@PathVariable Long id) {
        return cursoService.getCursoById(id);
    }

    @PostMapping
    public Curso createCurso(@RequestBody Curso curso) {
        return cursoService.createCurso(curso);
    }

    @PutMapping("/{id}")
    public Curso updateCurso(@PathVariable Long id, @RequestBody Curso curso) {
        return cursoService.updateCurso(id, curso);
    }

    @DeleteMapping("/{id}")
    public void deleteCurso(@PathVariable Long id) {
        cursoService.deleteCurso(id);
    }
    
    @PostMapping("/{cursoId}/professores/{professorId}")
    public Curso addProfessorToCurso(
            @PathVariable Long cursoId, @PathVariable Long professorId) {
        return cursoService.addProfessorToCurso(cursoId, professorId);
    }
    
    @DeleteMapping("/{cursoId}/professores/{professorId}")
    public Curso removeProfessorFromCurso(
            @PathVariable Long cursoId, @PathVariable Long professorId) {
        return cursoService.removeProfessorFromCurso(cursoId, professorId);
    }
}


