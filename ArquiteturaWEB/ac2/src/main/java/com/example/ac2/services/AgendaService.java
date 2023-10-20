package com.example.ac2.services;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import com.example.ac2.models.Agenda;
import com.example.ac2.models.Professor;
import com.example.ac2.repository.AgendaRepository;

@Service
public class AgendaService {
    @Autowired
    private AgendaRepository agendaRepository;

    public Agenda createAgenda(Agenda agenda) {
        if (!isProfessorAvailable(agenda.getProfessor(), agenda.getDataInicio(), agenda.getDataFim(), agenda.getHorarioInicio(), agenda.getHorarioFim())) {
            throw new RuntimeException("O professor não está disponível nesta data e horário.");
        }

        return agendaRepository.save(agenda);
    }

    public List<Agenda> getAllAgendas() {
        return agendaRepository.findAll();
    }

    public Agenda getAgendaById(Long id) {
        return agendaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agenda não encontrada com o ID especificado."));
    }

    public Agenda updateAgenda(Long id, Agenda updatedAgenda) {
        Agenda existingAgenda = getAgendaById(id);

        existingAgenda.setDataInicio(updatedAgenda.getDataInicio());
        existingAgenda.setDataFim(updatedAgenda.getDataFim());
        existingAgenda.setHorarioInicio(updatedAgenda.getHorarioInicio());
        existingAgenda.setHorarioFim(updatedAgenda.getHorarioFim());
        existingAgenda.setCidade(updatedAgenda.getCidade());
        existingAgenda.setEstado(updatedAgenda.getEstado());
        existingAgenda.setCep(updatedAgenda.getCep());
        existingAgenda.setProfessor(updatedAgenda.getProfessor());
        existingAgenda.setCurso(updatedAgenda.getCurso());

        return agendaRepository.save(existingAgenda);
    }

    public void deleteAgenda(Long id) {
        Agenda agenda = getAgendaById(id);
        agendaRepository.delete(agenda);
    }

    public boolean isProfessorAvailable(Professor professor, LocalDate dataInicio, LocalDate dataFim, String horarioInicio, String horarioFim) {
        List<Agenda> agendas = agendaRepository.findByProfessorAndDataInicioLessThanEqualAndDataFimGreaterThanEqual(professor, dataFim, dataInicio);

        for (Agenda agenda : agendas) {
            if (horarioInicio.compareTo(agenda.getHorarioFim()) < 0 && horarioFim.compareTo(agenda.getHorarioInicio()) > 0) {
                return false; 
            }
        }
        return true;
    }

    public List<Agenda> getAgendaByProfessorId(Long professorId) {
        return agendaRepository.findByProfessorId(professorId);
    }
}

