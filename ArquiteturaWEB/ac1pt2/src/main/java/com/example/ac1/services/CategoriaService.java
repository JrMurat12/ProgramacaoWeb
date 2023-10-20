package com.example.ac1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ac1.models.Categoria;
import com.example.ac1.repository.CategoriaRepository;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> obterTodasCategorias() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> obterCategoriaPorId(Integer id) {
        return categoriaRepository.findById(id);
    }

    public Categoria inserirCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria editarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public void excluirCategoria(Integer id) {
        categoriaRepository.deleteById(id);
    }
}
