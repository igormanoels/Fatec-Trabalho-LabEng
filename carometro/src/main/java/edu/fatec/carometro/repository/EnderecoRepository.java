package edu.fatec.carometro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.fatec.carometro.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, String> {}

