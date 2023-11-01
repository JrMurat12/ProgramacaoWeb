package ac2teste.ac2teste.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ac2teste.ac2teste.models.Agenda;
import ac2teste.ac2teste.models.Professor;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    List<Agenda> findByProfessorAndDataInicioLessThanEqualAndDataFimGreaterThanEqual(
            Professor professor, LocalDate dataFim, LocalDate dataInicio);
}
