package ac2teste.ac2teste.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac2teste.ac2teste.dtos.AgendaDTO;
import ac2teste.ac2teste.dtos.DadosProfessorDTO;
import ac2teste.ac2teste.dtos.ProfessorDTO;
import ac2teste.ac2teste.exceptions.RegraNegocioException;
import ac2teste.ac2teste.models.Agenda;
import ac2teste.ac2teste.models.Curso;
import ac2teste.ac2teste.models.Professor;
import ac2teste.ac2teste.repository.CursoRepository;
import ac2teste.ac2teste.repository.ProfessorRepository;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<ProfessorDTO> getAllProfessores() {
        List<ProfessorDTO> cursos = professorRepository.findAll().stream().map(
            (Professor pf) -> {
                return ProfessorDTO.builder()
                .id(pf.getId())
                .nome(pf.getNome())
                .cpf(pf.getCpf())
                .rg(pf.getRg())
                .endereco(pf.getEndereco())
                .celular(pf.getCelular())
                .build();
            }
        ).collect(Collectors.toList());

        return cursos;
    }

    @Override
    public DadosProfessorDTO getProfessorById(Long id) {
        return professorRepository.
        findProfessoresFetchAgendas(id)
        .map((Professor p) -> {
          return DadosProfessorDTO
            .builder()
            .id(p.getId())
            .nome(p.getNome())
            .cpf(p.getCpf())
            .rg(p.getRg())
            .endereco(p.getEndereco())
            .celular(p.getCelular())
            .agendas(
              p.getAgendas() != null
                ? p
                  .getAgendas()
                  .stream()
                  .map((Agenda a) -> {
                    return AgendaDTO
                      .builder()
                      .id(a.getId())
                      .dataInicio(a.getDataInicio())
                      .dataFim(a.getDataFim())
                      .horarioInicio(a.getHorarioInicio())
                      .horarioFim(a.getHorarioFim())
                      .cidade(a.getCidade())
                      .estado(a.getEstado())
                      .cep(a.getCep())
                      .professores_id(a.getProfessor().getId() != null ? a.getProfessor().getId(): 0)
                      .curso_id(a.getCurso().getId() != null ? a.getCurso().getId(): 0)
                      .build();
                  })
                  .collect(Collectors.toList())
                : null
            )
            .build();
        })
        .orElseThrow(() ->
          new RegraNegocioException("Professor não encontrado com o ID fornecido!")
        );
    }

    public void createProfessor(Professor professor) {
        professorRepository.save(professor);
    }

    public void updateProfessor(Long id, Professor professor) {
        Professor existingProfessor = professorRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Professor não encontrado com o ID especificado."));
        
        existingProfessor.setNome(professor.getNome());
        existingProfessor.setCpf(professor.getCpf());
        existingProfessor.setRg(professor.getRg());
        existingProfessor.setEndereco(professor.getEndereco());
        existingProfessor.setCelular(professor.getCelular());
        
        professorRepository.save(existingProfessor);
    }

    public void deleteProfessor(Long id) {
        Professor professor = professorRepository.findById(id)
        .orElseThrow(() -> new RegraNegocioException("Professor não encontrado com o ID especificado."));

        professorRepository.delete(professor);
    }

    public void addCursoToProfessor(Long professorId, Long cursoId) {
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new RegraNegocioException("Professor não encontrado com o ID especificado."));
        
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RegraNegocioException("Curso não encontrado com o ID especificado."));

        professor.getCursos().add(curso);
        
        professorRepository.save(professor);
    }

    public void removeCursoFromProfessor(Long professorId, Long cursoId) {
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new RegraNegocioException("Professor não encontrado com o ID especificado."));
        
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RegraNegocioException("Curso não encontrado com o ID especificado."));

        if (professor.getCursos().contains(curso)) {
            professor.getCursos().remove(curso);
            
            professorRepository.save(professor);
        } else {
            throw new RegraNegocioException("O professor não está associado a este curso.");
        }
    }
}

