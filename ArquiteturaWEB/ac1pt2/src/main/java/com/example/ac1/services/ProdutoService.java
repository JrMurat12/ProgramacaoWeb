package com.example.ac1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ac1.models.Produto;
import com.example.ac1.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> obterTodos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> obterPorId(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto inserir(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto editar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void excluir(Long id) {
        produtoRepository.deleteById(id);
    }
}
