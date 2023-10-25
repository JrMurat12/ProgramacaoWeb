// package com.example.ac2.services;

// import java.util.List;

// import org.springframework.stereotype.Service;

// import com.example.ac2.exceptions.RegraNegocioException;
// import com.example.ac2.models.Agenda;
// import com.example.ac2.repository.AgendaRepository;

// @Service
// public class AgendaServiceImpl implements AgendaService {

//     private final AgendaRepository agendaRepository;

//     public AgendaServiceImpl(AgendaRepository agendaRepository) {
//         this.agendaRepository = agendaRepository;
//     }

//     @Override
//     public Agenda salvar(Agenda agenda) {
//         Long idAgendaExistente = agenda.getId();

//         Agenda agendaExistente = agendaRepository.findById(idAgendaExistente).orElse(null);

//         if (agendaExistente != null) {

//             if (isProfessorDisponivel(agenda) && !hasConflitoDeHorario(agendaExistente, agenda)) {
//                 return agendaRepository.save(agenda);
//             } else {
//                 throw new RegraNegocioException("A agenda não podê ser atualizada!");
//             }
//         } else {
//             throw new RegraNegocioException("ID da Agenda não encontrado!");
//         }
//     }

//     @Override
//     public List<Agenda> listarTodos() {
//         return agendaRepository.findAll();
//     }

//     @Override
//     public Agenda obterPorId(Long id) {
//         return agendaRepository.findById(id).orElse(null);
//     }

//     @Override
//     public Agenda editar(Long id, Agenda agenda) {
//         if(agendaRepository.existsById(id)){
//             agenda.setId(id);
//             return agendaRepository.save(agenda);
//         }else {
//             return null;
//         }
//     }

//     @Override
//     public void excluir(Long id) {
//         agendaRepository.deleteById(id);
//     }

//     private boolean isProfessorDisponivel(Agenda agenda){

//         List<Agenda> agendaProfessor = agendaRepository.findByProfessor(agenda.getProfessor());

//         for (Agenda agendaExistente : agendaProfessor) {
//             if (hasConflitoDeHorario(agendaExistente, agenda)) {
//                 return false;
//             }
//         }

//         String especializacaoNecessaria = agenda.getCurso().getEspecializacao();


//         return agenda.getProfessor().getEspecializacao().contains(especializacaoNecessaria);
//     }

//     private boolean hasConflitoDeHorario(Agenda agendaExistente, Agenda novoAgendamento) {
//         return agendaExistente.getDataInicio().isBefore(novoAgendamento.getDataFim())
//                 && agendaExistente.getDataFim().isAfter(novoAgendamento.getDataInicio())
//                 && agendaExistente.getHorarioInicio().isBefore(novoAgendamento.getHorarioFim())
//                 && agendaExistente.getHorarioFim().isAfter(novoAgendamento.getHorarioInicio());
//     }
// }
