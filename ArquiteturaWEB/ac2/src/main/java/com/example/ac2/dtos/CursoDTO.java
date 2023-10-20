package com.example.ac2.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CursoDTO {
    private Integer id;
    private String descricao;
    private int cargaHoraria;
    private String objetivos;
    private String ementa;

    private List<Integer> professorCursoId;
}
