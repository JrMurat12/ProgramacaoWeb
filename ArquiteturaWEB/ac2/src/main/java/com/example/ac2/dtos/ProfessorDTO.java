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
public class ProfessorDTO {
    private Integer id;
    private String nome;
    private String cpf;
    private String rg;
    private String endereco;
    private String celular;

    private List<Integer> cursoProfessorId;
}