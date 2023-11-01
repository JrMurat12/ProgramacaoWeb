package ac2teste.ac2teste.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DadosAgendaDTO {
    private Long id;
    private LocalDate dataInicio;
    private LocalDate dataFinal;
    private LocalTime horarioInicio;
    private LocalTime horarioFim;
    private String cidade;
    private String estado;
    private String cep;

    private ProfessorDTO professores;
    private CursoDTO cursos;
}
