package com.example.ac2.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DadosAgendaDTO {
    private Long id;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String horarioInicio;
    private String horarioFim;
    private String cidade;
    private String estado;
    private String cep;

    private ProfessorDTO professor;

    private CursoDTO curso;
}
