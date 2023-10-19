package com.example.ac1.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProdutoDTO {
    private Long idproduto;
    private String prodnome;
    private double prodpreco;
    private Integer categoriaProdutoId;
}
