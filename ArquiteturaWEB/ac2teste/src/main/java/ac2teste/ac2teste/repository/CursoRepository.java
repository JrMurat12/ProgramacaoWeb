package ac2teste.ac2teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ac2teste.ac2teste.models.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    
}
