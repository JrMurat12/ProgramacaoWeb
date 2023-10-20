package com.example.ac1.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DadosProdutoDTO {
    private Long idproduto;
    private String prodnome;
    private Integer prodpreco;
    private CategoriaDTO categoria;
}
