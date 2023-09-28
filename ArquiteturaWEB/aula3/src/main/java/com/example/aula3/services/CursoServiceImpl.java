package com.example.aula3.services;

import org.springframework.stereotype.Service;

import com.example.aula3.dtos.CursoDTO;
import com.example.aula3.exceptions.RegraNegocioException;
import com.example.aula3.models.CategoriaCurso;
import com.example.aula3.models.Curso;
import com.example.aula3.repository.CategoriaCursoRepository;
import com.example.aula3.repository.CursoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;
    private final CategoriaCursoRepository categoriaCursoRepository;

    @Override
    public Curso salvar(CursoDTO cursoDTO) {
        CategoriaCurso categ = categoriaCursoRepository.findById(
            cursoDTO.getCategoriaCursoId()).orElseThrow(
                ()-> new RegraNegocioException("Código da categoria não encontrado!"));

        Curso c = new Curso();
        c.setCargaHoraria(cursoDTO.getCargaHoraria());
        c.setCategoriaCurso(categ);
        c.setNome(cursoDTO.getNome());
        return cursoRepository.save(c);
    }
    
}