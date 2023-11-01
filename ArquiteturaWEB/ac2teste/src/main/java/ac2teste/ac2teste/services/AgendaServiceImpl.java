package ac2teste.ac2teste.services;

import java.util.List;

import org.springframework.stereotype.Service;

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

    @Override
    public List<Agenda> getAllAgendas() {
        return agendaRepository.findAll();
    }

    @Override
    public Agenda getAgendaById(Long id) {
        return agendaRepository.findById(id).orElse(null);
    }

    @Override
    public Agenda updateAgenda(Agenda agenda, Long id) {
        if(agendaRepository.existsById(id)){
            agenda.setId(id);
            return agendaRepository.save(agenda);
        }else {
            return null;
        }
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

