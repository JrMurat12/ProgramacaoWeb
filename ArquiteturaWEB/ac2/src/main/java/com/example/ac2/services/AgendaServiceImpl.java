package com.example.ac2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ac2.exceptions.RegraNegocioException;
import com.example.ac2.models.Agenda;
import com.example.ac2.repository.AgendaRepository;
@Service
public class AgendaServiceImpl implements AgendaService {

    private final AgendaRepository agendaRepository;

    @Autowired
    public AgendaServiceImpl(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    @Override
    public Agenda salvar(Agenda agenda) {
        if(professorIsAvailable(agenda)){
            return agendaRepository.save(agenda);
        } else {
            throw new RegraNegocioException("O professor não está disponível para esta agenda.");
        }
    }

    @Override
    public List<Agenda> listarTodos() {
        return agendaRepository.findAll();
    }

    @Override
    public Agenda obterPorId(Long id) {
        return agendaRepository.findById(id).orElse(null);
    }

    @Override
    public Agenda atualizar(Agenda agenda, Long id) {
        if(professorIsAvailable(agenda)) {
            if (agendaRepository.existsById(id)) {
                agenda.setId(id);
                return agendaRepository.save(agenda);
            }
        }
        return null;
    }

    @Override
    public void deletar(Long id) {
        agendaRepository.deleteById(id);
    }

    @Override
    public boolean professorIsAvailable(Agenda novaAgenda) {
        List<Agenda> agendasDoProfessor = agendaRepository.findByProfessorAndDataInicioLessThanEqualAndDataFimGreaterThanEqual(
                novaAgenda.getProfessor(), novaAgenda.getDataFim(), novaAgenda.getDataInicio());

        return agendasDoProfessor.stream()
                .noneMatch(agenda -> agenda.getId().equals(novaAgenda.getId()) || overlap(agenda, novaAgenda));
    }

    private boolean overlap(Agenda agendaExistente, Agenda novaAgenda) {
        return (novaAgenda.getDataInicio().isBefore(agendaExistente.getDataFim()) || novaAgenda.getDataInicio().equals(agendaExistente.getDataFim())) &&
                (novaAgenda.getDataFim().isAfter(agendaExistente.getDataInicio()) || novaAgenda.getDataFim().equals(agendaExistente.getDataInicio()));
    }

}