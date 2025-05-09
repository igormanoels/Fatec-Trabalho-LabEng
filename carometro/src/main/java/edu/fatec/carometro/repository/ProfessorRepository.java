package edu.fatec.carometro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.fatec.carometro.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, String> {}

