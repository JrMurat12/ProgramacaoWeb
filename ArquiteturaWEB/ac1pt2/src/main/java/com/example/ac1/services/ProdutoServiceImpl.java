package com.example.ac1.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.ac1.dtos.CategoriaDTO;
import com.example.ac1.dtos.DadosProdutoDTO;
import com.example.ac1.dtos.ProdutoDTO;
import com.example.ac1.exceptions.RegraNegocioException;
import com.example.ac1.models.Categoria;
import com.example.ac1.models.Produto;
import com.example.ac1.repository.CategoriaRepository;
import com.example.ac1.repository.ProdutoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    @Override
    public Produto salvar(ProdutoDTO produtoDTO) {
        Categoria categ = categoriaRepository.findById(
                        produtoDTO.getCategoriaProdutoId()).orElseThrow(
                                        () -> new RegraNegocioException("Código da categoria não encontrado!"));

        Produto p = new Produto();
        p.setProd_preco(produtoDTO.getProdpreco());
        p.setCategoriaProduto(categ);
        p.setProd_nome(produtoDTO.getProdnome());
        return produtoRepository.save(p);
    }

        public List<ProdutoDTO> listarTodos() {
            List<ProdutoDTO> produtos = produtoRepository.findAll().stream().map(
                            (Produto p) -> {
                                    return ProdutoDTO.builder()
                                                    .idproduto(p.getId_produto())
                                                    .prodnome(p.getProd_nome())
                                                    .prodpreco(p.getProd_preco())
                                                    .categoriaProdutoId(
                                                                    p.getCategoriaProduto() == null ? 0
                                                                                    : p.getCategoriaProduto().getId_categoria())
                                                    .build();
                            }).collect(Collectors.toList());
            return produtos;
        }

        @Override
        public DadosProdutoDTO obterPorId(Long id) {
                return produtoRepository.findById(id).map((Produto p) -> {
                        return DadosProdutoDTO.builder()
                                        .idproduto(p.getId_produto())
                                        .prodnome(p.getProd_nome())
                                        .prodpreco(p.getProd_preco())
                                        .categoria(p.getCategoriaProduto() != null ? CategoriaDTO.builder()
                                                        .idcategoria(p.getCategoriaProduto().getId_categoria())
                                                        .catnome(p.getCategoriaProduto().getCat_nome())
                                                        .build() : null)
                                        .build();
                })
                                .orElseThrow(
                                                () -> new RegraNegocioException("Id do produto não encontrado"));
        }

        @Override
        public void excluir(Long id) {
                produtoRepository.deleteById(id);
        }

        @Override
        public void editar(Long id, ProdutoDTO dto) {
                Produto produto = produtoRepository.findById(id)
                                 .orElseThrow(() -> new RegraNegocioException("Produto não encontrado."));

                Categoria categoriaProduto = categoriaRepository.findById(dto.getCategoriaProdutoId())
                                 .orElseThrow(() -> new RegraNegocioException("Categoria não encontrada."));

                produto.setProd_nome(dto.getProdnome());
                produto.setProd_preco(dto.getProdpreco());
                produto.setCategoriaProduto(categoriaProduto);
                produtoRepository.save(produto);
        }

}
