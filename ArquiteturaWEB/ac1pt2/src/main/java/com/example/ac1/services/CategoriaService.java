package com.example.ac1.services;

import java.util.List;

import com.example.ac1.dtos.CategoriaDTO;
import com.example.ac1.models.Categoria;

public interface CategoriaService {
    Categoria salvar(CategoriaDTO categoriaDTO);

    List<CategoriaDTO> listarTodos();

    CategoriaDTO obterPorId(Integer id);

    void excluir(Integer id);

    void editar(Integer id, CategoriaDTO dto);

}
