package edu.fatec.carometro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.fatec.carometro.model.TipoAcessoUsuario;
import edu.fatec.carometro.model.TipoAcessoUsuarioId;

public interface TipoAcessoUsuarioRepository extends JpaRepository<TipoAcessoUsuario, TipoAcessoUsuarioId> {}

