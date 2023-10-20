package com.example.ac1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.ac1.models.Categoria;
import com.example.ac1.services.CategoriaService;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> obterTodasCategorias() {
        return categoriaService.obterTodasCategorias();
    }

    @GetMapping("/{id}")
    public Categoria obterCategoriaPorId(@PathVariable Integer id) {
        return categoriaService.obterCategoriaPorId(id).orElse(null);
    }

    @PostMapping
    public Categoria inserirCategoria(@RequestBody Categoria categoria) {
        return categoriaService.inserirCategoria(categoria);
    }

    @PutMapping
    public Categoria editarCategoria(@RequestBody Categoria categoria) {
        return categoriaService.editarCategoria(categoria);
    }

    @DeleteMapping("/{id}")
    public void excluirCategoria(@PathVariable Integer id) {
        categoriaService.excluirCategoria(id);
    }
}
