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
import com.example.ac2.services.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<Curso> listarCursos() {
        return cursoService.listarTodos();
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarCurso(@RequestBody Curso novoCurso) {
        try {
            cursoService.salvar(novoCurso);
            return new ResponseEntity<>("Curso criado com sucesso", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao criar o curso: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{cursoId}")
    public ResponseEntity<Curso> obterCursoPorId(@PathVariable Long cursoId) {
        Curso curso = cursoService.obterPorId(cursoId);
        if (curso != null) {
            return new ResponseEntity<>(curso, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{cursoId}")
    public ResponseEntity<String> atualizarCurso(@PathVariable Long cursoId, @RequestBody Curso cursoAtualizado) {
        try {
            Curso curso = cursoService.obterPorId(cursoId);
            if (curso != null) {
                cursoService.atualizar(cursoAtualizado, cursoId);
                return new ResponseEntity<>("Curso atualizado com sucesso", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Curso não encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao atualizar o curso: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{cursoId}")
    public ResponseEntity<String> excluirCurso(@PathVariable Long cursoId) {
        try {
            Curso curso = cursoService.obterPorId(cursoId);
            if (curso != null) {
                cursoService.deletar(cursoId);
                return new ResponseEntity<>("Curso excluído com sucesso", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Curso não encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao excluir o curso: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


