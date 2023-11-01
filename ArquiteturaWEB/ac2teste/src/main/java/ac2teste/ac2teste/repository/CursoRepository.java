package ac2teste.ac2teste.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ac2teste.ac2teste.models.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    @Query("SELECT cs FROM Curso cs LEFT JOIN FETCH cs.professores WHERE cs.id = :id")
    Optional<Curso> findCursosFetchProfessores(@Param("id") Long id);
}
