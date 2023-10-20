package com.example.ac2.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ac2.models.Agenda;
import com.example.ac2.models.Professor;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    List<Agenda> findByProfessorAndDataInicioLessThanEqualAndDataFimGreaterThanEqual(Professor professor, LocalDate dataFim, LocalDate dataInicio);
    List<Agenda> findByProfessorId(Long professorId);
}
