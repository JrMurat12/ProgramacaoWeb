package com.example.ac2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ac2.models.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {

}
