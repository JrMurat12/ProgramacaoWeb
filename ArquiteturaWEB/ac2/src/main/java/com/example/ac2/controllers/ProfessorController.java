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

import com.example.ac2.models.Curso;
import com.example.ac2.models.Professor;
import com.example.ac2.services.CursoService;
import com.example.ac2.services.ProfessorServiceImpl;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private ProfessorServiceImpl professorService;

    @GetMapping
    public List<Professor> listarProfessores() {
        return professorService.listarTodos();
    }

    @GetMapping("/especializados/{cursoId}")
    public List<Professor> listarProfessoresEspecializados(@PathVariable Long cursoId) {
        Curso curso = cursoService.obterPorId(cursoId);
        return professorService.getProfessoresEspecializados(curso);
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarProfessor(@RequestBody Professor novoProfessor) {
        try {
            professorService.salvar(novoProfessor);
            return new ResponseEntity<>("Professor criado com sucesso", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao criar o professor: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{professorId}")
    public ResponseEntity<Professor> obterProfessorPorId(@PathVariable Long professorId) {
        Professor professor = professorService.obterPorId(professorId);
        if (professor != null) {
            return new ResponseEntity<>(professor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{professorId}")
    public ResponseEntity<String> atualizarProfessor(@PathVariable Long professorId, @RequestBody Professor professorAtualizado) {
        try {
            Professor professor = professorService.obterPorId(professorId);
            if (professor != null) {
                professorService.atualizar(professorAtualizado,professorId);
                return new ResponseEntity<>("Professor atualizado com sucesso", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Professor não encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao atualizar o professor: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{professorId}")
    public ResponseEntity<String> excluirProfessor(@PathVariable Long professorId) {
        try {
            Professor professor = professorService.obterPorId(professorId);
            if (professor != null) {
                professorService.deletar(professorId);
                return new ResponseEntity<>("Professor excluído com sucesso", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Professor não encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao excluir o professor: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


