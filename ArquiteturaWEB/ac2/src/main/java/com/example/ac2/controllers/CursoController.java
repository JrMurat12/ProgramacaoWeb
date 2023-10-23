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
    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public List<Curso> listarTodosCursos() {
        return cursoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Curso listarCursoPorID(@PathVariable Integer id) {
        return cursoService.obterPorId(id);
    }

    @PostMapping
    public Curso criarCurso(@RequestBody Curso curso) {
        return cursoService.salvar(curso);
    }

    @PutMapping("/{id}")
    public Curso atualizarCurso(@PathVariable Integer id, @RequestBody Curso curso) {
        return cursoService.editar(id, curso);
    }

    @DeleteMapping("/{id}")
    public void deletarCurso(@PathVariable Integer id) {
        cursoService.excluir(id);
    }
}


