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

import ac2teste.ac2teste.models.Professor;
import ac2teste.ac2teste.services.ProfessorService;

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
    public void addCursoToProfessor(
            @PathVariable Long professorId, @PathVariable Long cursoId) {
        professorService.addCursoToProfessor(professorId, cursoId);
    }
    
    @DeleteMapping("/{professorId}/cursos/{cursoId}")
    public void removeCursoFromProfessor(
            @PathVariable Long professorId, @PathVariable Long cursoId) {
        professorService.removeCursoFromProfessor(professorId, cursoId);
    }
}



