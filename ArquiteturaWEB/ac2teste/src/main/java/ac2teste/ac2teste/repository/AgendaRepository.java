package ac2teste.ac2teste.repository;

import java.time.LocalDate;
// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ac2teste.ac2teste.models.Agenda;
// import ac2teste.ac2teste.models.Professor;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    // List<Agenda> findByProfessorAndDataInicioLessThanEqualAndDataFimGreaterThanEqual(
    //         Professor professor, LocalDate dataFim, LocalDate dataInicio);

    @Query("SELECT ag FROM Agenda ag LEFT JOIN FETCH ag.professor WHERE ag.id = :id")
    Agenda findAgendaFetchProfessor(@Param("id") Long id);

    @Query("SELECT ag FROM Agenda ag LEFT JOIN FETCH ag.professor WHERE ag.dataInicio = :dataInicio")
    Agenda findByDataFinal(@Param("dataInicio") LocalDate dataInicio);

    boolean existsByProfessorId(Long id);

    boolean existsByCursoId(Long id);
}
