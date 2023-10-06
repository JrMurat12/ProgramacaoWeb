package com.example.aula3.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CursoDTO {
    private Long id;
    private String nome;
    private int cargaHoraria;
    private Integer categoriaCursoId;
}
