package edu.fatec.carometro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.fatec.carometro.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, String> {}

