package edu.fatec.carometro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.fatec.carometro.model.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {}

