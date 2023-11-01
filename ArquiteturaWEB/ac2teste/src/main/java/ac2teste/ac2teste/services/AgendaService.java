package ac2teste.ac2teste.services;

import java.util.List;

import ac2teste.ac2teste.models.Agenda;

public interface AgendaService {

    void createAgenda(Agenda agenda);
    List<Agenda> getAllAgendas();
    Agenda getAgendaById(Long id);
    Agenda updateAgenda(Agenda agenda, Long id);
    void deleteAgenda(Long id);

}
