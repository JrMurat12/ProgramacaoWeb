package ac2teste.ac2teste.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CursoDTO {
    private Long id;
    private String descricao;
    private double cargaHoraria;
    private String objetivos;
    private String ementa;

    private ProfessorDTO professores;
}
