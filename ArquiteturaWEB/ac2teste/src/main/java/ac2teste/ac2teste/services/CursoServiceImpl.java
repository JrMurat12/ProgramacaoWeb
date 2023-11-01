package ac2teste.ac2teste.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac2teste.ac2teste.dtos.CursoDTO;
import ac2teste.ac2teste.dtos.DadosCursoDTO;
import ac2teste.ac2teste.dtos.ProfessorDTO;
import ac2teste.ac2teste.exceptions.RegraNegocioException;
import ac2teste.ac2teste.models.Curso;
import ac2teste.ac2teste.models.Professor;
import ac2teste.ac2teste.repository.CursoRepository;
// import ac2teste.ac2teste.repository.ProfessorRepository;

@Service
public class CursoServiceImpl implements CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    // @Autowired
    // private ProfessorRepository professorRepository;

    // public List<Curso> getAllCursos() {
    //     return cursoRepository.findAll();
    // }

    @Override
    public List<CursoDTO> getAllCursos() {
        List<CursoDTO> cursos = cursoRepository
        .findAll()
        .stream()
        .map((Curso c) -> {
            return CursoDTO
            .builder()
            .id(c.getId())
            .descricao(c.getDescricao())
            .cargaHoraria(c.getCargaHoraria())
            .objetivos(c.getObjetivos())
            .ementa(c.getEmenta())
            .build();
        })
        .collect(Collectors.toList());

        return cursos;
    }

    // public Curso getCursoById(Long id) {
    //     return cursoRepository.findById(id).orElse(null);
    // }

    @Override
    public DadosCursoDTO getCursoById(Long id) {
      return cursoRepository
        .findCursosFetchProfessores(id)
        .map((Curso c) -> {
          return DadosCursoDTO
            .builder()
            .id(c.getId())
            .descricao(c.getDescricao())
            .cargaHoraria(c.getCargaHoraria())
            .objetivos(c.getObjetivos())
            .ementa(c.getEmenta())
            .professores(
              c.getProfessores() != null
                ? c
                  .getProfessores()
                  .stream()
                  .map((Professor p) -> {
                    return ProfessorDTO
                      .builder()
                      .id(p.getId())
                      .nome(p.getNome())
                      .cpf(p.getCpf())
                      .rg(p.getRg())
                      .endereco(p.getEndereco())
                      .celular(p.getCelular())
                      .build();
                  })
                  .collect(Collectors.toList())
                : null
            )
            .build();
        })
        .orElseThrow(() ->
          new RegraNegocioException("Curso não encontrado com o ID fornecido!")
        );
    }

    public void createCurso(Curso curso) {
        cursoRepository.save(curso);
    }

    public void updateCurso(Long id, Curso curso) {
        Curso existingCurso = cursoRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Curso não encontrado com o ID especificado."));

        existingCurso.setDescricao(curso.getDescricao());
        existingCurso.setCargaHoraria(curso.getCargaHoraria());
        existingCurso.setObjetivos(curso.getObjetivos());
        existingCurso.setEmenta(curso.getEmenta());

        cursoRepository.save(existingCurso);
    }

    public void deleteCurso(Long id) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Curso não encontrado com o ID especificado."));

        cursoRepository.delete(curso);
    }

    // public void addProfessorToCurso(Long cursoId, Long professorId) {
    //     Curso curso = cursoRepository.findById(cursoId)
    //             .orElseThrow(() -> new RegraNegocioException("Curso não encontrado com o ID especificado."));

    //     Professor professor = professorRepository.findById(professorId)
    //             .orElseThrow(() -> new RegraNegocioException("Professor não encontrado com o ID especificado."));

    //     curso.getProfessores().add(professor);
        
    //     cursoRepository.save(curso);
    // }

    // public void removeProfessorFromCurso(Long cursoId, Long professorId) {
    //     Curso curso = cursoRepository.findById(cursoId)
    //             .orElseThrow(() -> new RegraNegocioException("Curso não encontrado com o ID especificado."));
        
    //     Professor professor = professorRepository.findById(professorId)
    //             .orElseThrow(() -> new RegraNegocioException("Professor não encontrado com o ID especificado."));

    //     if (curso.getProfessores().contains(professor)) {
    //         curso.getProfessores().remove(professor);
            
    //         cursoRepository.save(curso);
    //     } else {
    //         throw new RegraNegocioException("O professor não está associado a este curso.");
    //     }
    // }
}




