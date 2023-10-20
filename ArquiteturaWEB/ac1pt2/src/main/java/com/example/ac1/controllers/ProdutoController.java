package com.example.ac1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.ac1.models.Produto;
import com.example.ac1.services.ProdutoService;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> obterTodosProdutos() {
        return produtoService.obterTodos();
    }

    @GetMapping("/{id}")
    public Produto obterProdutoPorId(@PathVariable Long id) {
        return produtoService.obterPorId(id).orElse(null);
    }

    @PostMapping
    public Produto inserirProduto(@RequestBody Produto produto) {
        return produtoService.inserir(produto);
    }

    @PutMapping
    public Produto editarProduto(@RequestBody Produto produto) {
        return produtoService.editar(produto);
    }

    @DeleteMapping("/{id}")
    public void excluirProduto(@PathVariable Long id) {
        produtoService.excluir(id);
    }
}
