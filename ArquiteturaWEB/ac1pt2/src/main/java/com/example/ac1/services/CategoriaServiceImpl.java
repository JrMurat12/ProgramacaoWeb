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

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Override
    public Categoria salvar(CategoriaDTO categoriaDTO) {
        // Categoria categ = categoriaRepository.findById(
        //                 produtoDTO.getCategoriaProdutoId()).orElseThrow(
        //                                 () -> new RegraNegocioException("Código da categoria não encontrado!"));

        Categoria c = new Categoria();
        c.setCat_nome(categoriaDTO.getCatnome());
        // p.setCategoriaProduto(categ);
        // p.setProd_nome(produtoDTO.getProdnome());
        return categoriaRepository.save(c);
    }
    
    public List<CategoriaDTO> listarTodos() {
        List<CategoriaDTO> categorias = categoriaRepository.findAll().stream().map(
                        (Categoria c) -> {
                                return CategoriaDTO.builder()
                                                .idcategoria(c.getId_categoria())
                                                .catnome(c.getCat_nome())
                                                // .prodpreco(p.getProd_preco())
                                                // .categoriaProdutoId(
                                                //                 p.getCategoriaProduto() == null ? 0
                                                //                             : p.getCategoriaProduto().getId_categoria())
                                                .build();
                        }).collect(Collectors.toList());
        return categorias;
    }

    @Override
    public CategoriaDTO obterPorId(Integer id) {
            return categoriaRepository.findById(id).map((Categoria c) -> {
                    return CategoriaDTO.builder()
                                    .idcategoria(c.getId_categoria())
                                    .catnome(c.getCat_nome())
                                    // .prodpreco(p.getProd_preco())
                                    // .categoria(p.getCategoriaProduto() != null ? CategoriaDTO.builder()
                                    //                 .idcategoria(p.getCategoriaProduto().getId_categoria())
                                    //                 .catnome(p.getCategoriaProduto().getCat_nome())
                                    //                 .build() : null)
                                    .build();
            })
                            .orElseThrow(
                                            () -> new RegraNegocioException("Id do produto não encontrado"));
    }

    @Override
    public void excluir(Integer id) {
        categoriaRepository.deleteById(id);
    }

    @Override
    public void editar(Integer id, CategoriaDTO dto) {
            Categoria categoria = categoriaRepository.findById(id)
                             .orElseThrow(() -> new RegraNegocioException("Categoria não encontrado."));

            // Categoria categoriaProduto = categoriaRepository.findById(dto.getCategoriaProdutoId())
            //                  .orElseThrow(() -> new RegraNegocioException("Categoria não encontrada."));

            categoria.setCat_nome(dto.getCatnome());
            // categoria.setProd_preco(dto.getProdpreco());
            // produto.setCategoriaProduto(categoriaProduto);
            categoriaRepository.save(categoria);
    }
}
