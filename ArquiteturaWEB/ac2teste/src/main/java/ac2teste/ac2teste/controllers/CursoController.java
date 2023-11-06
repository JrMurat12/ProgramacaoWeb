package ac2teste.ac2teste.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ac2teste.ac2teste.dtos.CursoDTO;
import ac2teste.ac2teste.dtos.DadosCursoDTO;
import ac2teste.ac2teste.models.Curso;
import ac2teste.ac2teste.services.CursoService;

@RestController
@RequestMapping("/api/curso")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<CursoDTO> getAllCursos() {
        return cursoService.getAllCursos();
    }

    @GetMapping("/{id}")
    public DadosCursoDTO getCursoById(@PathVariable Long id) {
        return cursoService.getCursoById(id);
    }

    @PostMapping
    public void createCurso(@RequestBody Curso curso) {
        cursoService.createCurso(curso);
    }

    @PutMapping("/{id}")
    public void updateCurso(@PathVariable Long id, @RequestBody Curso curso) {
        cursoService.updateCurso(id, curso);
    }

    @DeleteMapping("/{id}")
    public void deleteCurso(@PathVariable Long id) {
        cursoService.deleteCurso(id);
    }
}


