package edu.fatec.carometro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.fatec.carometro.model.PessoaFisica;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, String> {}

