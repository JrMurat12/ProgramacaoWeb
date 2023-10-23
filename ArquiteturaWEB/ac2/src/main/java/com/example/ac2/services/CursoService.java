package com.example.ac2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ac2.dtos.CursoDTO;
import com.example.ac2.dtos.DadosCursoDTO;
import com.example.ac2.models.Curso;
import com.example.ac2.repository.CursoRepository;

public interface CursoService {
    Curso salvar(Curso curso);

    List<Curso> listarTodos();

    Curso obterPorId(Integer id);

    void excluir(Integer id);

    Curso editar(Integer id, Curso curso);
}


