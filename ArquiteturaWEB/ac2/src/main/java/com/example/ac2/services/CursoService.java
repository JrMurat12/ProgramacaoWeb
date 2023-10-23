package com.example.ac2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ac2.dtos.CursoDTO;
import com.example.ac2.dtos.DadosCursoDTO;
import com.example.ac2.models.Curso;
import com.example.ac2.repository.CursoRepository;

@Service
public class CursoService {
    
    private final CursoRepository cursoRepository;

    @Autowired
    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<Curso> getAllCursos() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> getCursoById(Integer id) {
        return cursoRepository.findById(id);
    }

    public Curso saveCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Curso updateCurso(Integer id, Curso curso) {
        if (cursoRepository.existsById(id)) {
            curso.setId(id);
            return cursoRepository.save(curso);
        } else {
            return null;
        }
    }

    public void deleteCurso(Integer id) {
        cursoRepository.deleteById(id);
    }
    // Curso salvar(CursoDTO cursoDTO);

    // List<CursoDTO> listarTodos();

    // DadosCursoDTO obterPorId(Integer id);

    // void excluir(Integer id);

    // void editar(Integer id, CursoDTO dto);
}


