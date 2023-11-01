package ac2teste.ac2teste.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import ac2teste.ac2teste.dtos.AgendaDTO;
import ac2teste.ac2teste.dtos.CursoDTO;
import ac2teste.ac2teste.dtos.DadosAgendaDTO;
import ac2teste.ac2teste.dtos.ProfessorDTO;
import ac2teste.ac2teste.exceptions.RegraNegocioException;
import ac2teste.ac2teste.models.Agenda;
import ac2teste.ac2teste.models.Curso;
import ac2teste.ac2teste.models.Professor;
import ac2teste.ac2teste.repository.AgendaRepository;
import ac2teste.ac2teste.repository.CursoRepository;
import ac2teste.ac2teste.repository.ProfessorRepository;

@Service
public class AgendaServiceImpl implements AgendaService {

    private final CursoRepository cursoRepository;
    private final ProfessorRepository professorRepository;
    private final AgendaRepository agendaRepository;

    public AgendaServiceImpl(CursoRepository cursoRepository, ProfessorRepository professorRepository, AgendaRepository agendaRepository) {
        this.cursoRepository = cursoRepository;
        this.professorRepository = professorRepository;
        this.agendaRepository = agendaRepository;
    }

    @Override
    public void createAgenda(Agenda agenda) {
        Professor professor = professorRepository.findById(agenda.getProfessor().getId()).orElseThrow(() -> new RegraNegocioException("Erro ao encontrar Professor"));
        Curso curso = cursoRepository.findById(agenda.getCurso().getId()).orElseThrow(() -> new RegraNegocioException("Erro ao encontrar Curso"));

        Agenda agendamento = new Agenda();
        agendamento.setDataInicio(agenda.getDataInicio());
        agendamento.setDataFim(agenda.getDataFim());
        agendamento.setHorarioInicio(agenda.getHorarioInicio());
        agendamento.setHorarioFim(agenda.getHorarioFim());
        agendamento.setEstado(agenda.getEstado());
        agendamento.setCidade(agenda.getCidade());
        agendamento.setCep(agenda.getCep());
        agendamento.setCurso(curso);
        agendamento.setProfessor(professor);
    

        agendaRepository.save(agendamento);
    }

    // @Override
    // public List<Agenda> getAllAgendas() {
    //     return agendaRepository.findAll();
    // }

    @Override
    public List<AgendaDTO> getAllAgendas() {
        List<AgendaDTO> agenda = agendaRepository.findAll().stream().map(
            (Agenda a) -> {
                return AgendaDTO.builder()
                .id(a.getId())
                .dataInicio(a.getDataInicio())
                .dataFinal(a.getDataFim())
                .horarioInicio(a.getHorarioInicio())
                .horarioFim(a.getHorarioFim())
                .cidade(a.getCidade())
                .estado(a.getEstado())
                .cep(a.getCep())
                .professores_id(a.getProfessor().getId() != null ? a.getProfessor().getId(): 0)
                .curso_id(a.getCurso().getId() != null ? a.getCurso().getId(): 0)
                .build();
            }
        ).collect(Collectors.toList());

        return agenda;
    }

    // @Override
    // public Agenda getAgendaById(Long id) {
    //     return agendaRepository.findById(id).orElse(null);
    // }

    @Override
    public DadosAgendaDTO getAgendaById(Long id) {
        return agendaRepository.findById(id).map(
            (Agenda ag) -> {
                return DadosAgendaDTO.builder()
                .id(ag.getId())
                .professores(ag.getProfessor() != null ?
                    ProfessorDTO.builder()
                    .id(ag.getProfessor().getId())
                    .nome(ag.getProfessor().getNome())
                    .cpf(ag.getProfessor().getCpf())
                    .rg(ag.getProfessor().getRg())
                    .endereco(ag.getProfessor().getEndereco())
                    .celular(ag.getProfessor().getCelular())
                    .build() : null)

                .cursos(ag.getCurso() != null ?
                    CursoDTO.builder()
                    .id(ag.getCurso().getId())
                    .descricao(ag.getCurso().getDescricao())
                    .cargaHoraria(ag.getCurso().getCargaHoraria())
                    .objetivos(ag.getCurso().getObjetivos())
                    .ementa(ag.getCurso().getEmenta())
                    .build() : null)

                .dataInicio(ag.getDataInicio())
                .dataFinal(ag.getDataFim())
                .horarioInicio(ag.getHorarioInicio())
                .horarioFim(ag.getHorarioFim())
                .cidade(ag.getCidade())
                .estado(ag.getEstado())
                .cep(ag.getCep())
                .build();
            }
        ).orElseThrow(
            () -> new RegraNegocioException("Agenda não foi encontrada com o ID Fornecido!")
        );
    }

    @Override
    public void updateAgenda(Agenda agenda, Long id) {
            agenda.setId(id);
            agendaRepository.save(agenda);
    }

    @Override
    public void deleteAgenda(Long id) {
        agendaRepository.deleteById(id);
    }

    // private boolean isProfessorDisponivel(Agenda agenda){

    //     List<Agenda> agendamentosDoProfessor = agendaRepository.findByProfessor(agenda.getProfessor());

    //     for (Agenda agendamentoExistente : agendamentosDoProfessor) {
    //         if (hasConflitoDeHorario(agendamentoExistente, agenda)) {
    //             return false;
    //         }
    //     }

    //     String especializacaoNecessaria = agenda.getCurso().getEspecializacao();


    //     return agenda.getProfessor().getEspecializacoes().contains(especializacaoNecessaria);
    // }

    // private boolean hasConflitoDeHorario(Agenda agendaExistente, Agenda novaAgenda) {
    //     return agendaExistente.getDataInicio().isBefore(novaAgenda.getDataFim())
    //             && agendaExistente.getDataFim().isAfter(novaAgenda.getDataInicio())
    //             && agendaExistente.getHorarioInicio().isBefore(novaAgenda.getHorarioFim())
    //             && agendaExistente.getHorarioFim().isAfter(novaAgenda.getHorarioInicio());
    // }
}

