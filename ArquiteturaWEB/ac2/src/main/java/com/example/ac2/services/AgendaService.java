package com.example.ac2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ac2.dtos.AgendaDTO;
import com.example.ac2.dtos.DadosAgendaDTO;
import com.example.ac2.models.Agenda;
import com.example.ac2.repository.AgendaRepository;

@Service
public class AgendaService {
    
    private final AgendaRepository agendaRepository;

    @Autowired
    public AgendaService(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    public List<Agenda> getAllAgendas() {
        return agendaRepository.findAll();
    }

    public Optional<Agenda> getAgendaById(Long id) {
        return agendaRepository.findById(id);
    }

    public Agenda saveAgenda(Agenda agenda) {
        return agendaRepository.save(agenda);
    }

    public Agenda updateAgenda(Long id, Agenda agenda) {
        if (agendaRepository.existsById(id)) {
            agenda.setId(id);
            return agendaRepository.save(agenda);
        } else {
            return null;
        }
    }

    public void deleteAgenda(Long id) {
        agendaRepository.deleteById(id);
    }
    // Agenda salvar(AgendaDTO agendaDTO);

    // List<AgendaDTO> listarTodos();

    // DadosAgendaDTO obterPorId(Long id);

    // void excluir(Long id);

    // void editar(Long id, AgendaDTO dto);
}

