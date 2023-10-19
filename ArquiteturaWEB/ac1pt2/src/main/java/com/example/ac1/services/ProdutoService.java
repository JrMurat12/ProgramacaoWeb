package com.example.ac1.services;

import java.util.List;

import com.example.ac1.dtos.DadosProdutoDTO;
import com.example.ac1.dtos.ProdutoDTO;
import com.example.ac1.models.Produto;

public interface ProdutoService {
    Produto salvar(ProdutoDTO cursoDTO);
    List<ProdutoDTO> listarProdutos();
    DadosProdutoDTO obterPorId(Long id);
    void excluir(Long id);
    void editar(Long id, ProdutoDTO dto);
}
