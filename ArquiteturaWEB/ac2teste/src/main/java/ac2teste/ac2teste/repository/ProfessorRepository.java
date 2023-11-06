package ac2teste.ac2teste.repository;

import java.util.Optional;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ac2teste.ac2teste.models.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    // @Query("SELECT p FROM Professor p JOIN p.cursos c WHERE c = :curso")
    // List<Professor> findByCursosContaining(@Param("curso") Curso curso);

    // @Query("SELECT cs FROM Curso cs LEFT JOIN FETCH cs.professores WHERE cs.id = :id")
    // Curso findCursosFetchProfessores(@Param("id") Long id);

    @Query("SELECT ps FROM Professor ps LEFT JOIN FETCH ps.agendas WHERE ps.id = :id")
    Optional<Professor> findProfessoresFetchAgendas(@Param("id") Long id);
}
