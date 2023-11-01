package ac2teste.ac2teste.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DadosCursoDTO {
    private Long id;
    private String descricao;
    private double cargaHoraria;
    private String objetivos;
    private String ementa;
    private List<ProfessorDTO> professores;
}