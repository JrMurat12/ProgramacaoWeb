package com.example.ac1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.ac1.dtos.CategoriaDTO;
import com.example.ac1.dtos.DadosProdutoDTO;
import com.example.ac1.dtos.ProdutoDTO;
import com.example.ac1.models.Categoria;
import com.example.ac1.services.CategoriaService;
import com.example.ac1.services.ProdutoService;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer inserir(@RequestBody CategoriaDTO categoriaDTO) {
        return categoriaService.salvar(categoriaDTO).getId_categoria();
    }

    @GetMapping
    public List<CategoriaDTO> listarTodos() {
        return categoriaService.listarTodos();
    }

    @GetMapping("{id}")
    public CategoriaDTO obterPorId(@PathVariable Integer id) {
        return categoriaService.obterPorId(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        categoriaService.excluir(id);
    }

    @PutMapping("{id}")
    public void edit(@PathVariable Integer id, @RequestBody CategoriaDTO dto) {
        categoriaService.editar(id, dto);
    }

}
