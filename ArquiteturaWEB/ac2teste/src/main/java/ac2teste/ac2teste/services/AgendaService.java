package ac2teste.ac2teste.services;

import java.util.List;

import ac2teste.ac2teste.dtos.AgendaDTO;
import ac2teste.ac2teste.dtos.DadosAgendaDTO;
import ac2teste.ac2teste.models.Agenda;

public interface AgendaService {

    void createAgenda(Agenda agenda);
    List<AgendaDTO> getAllAgendas();
    DadosAgendaDTO getAgendaById(Long id);
    void updateAgenda(Agenda agenda, Long id);
    void deleteAgenda(Long id);
    boolean professorIsAvailable(Agenda novaAgenda);

}
