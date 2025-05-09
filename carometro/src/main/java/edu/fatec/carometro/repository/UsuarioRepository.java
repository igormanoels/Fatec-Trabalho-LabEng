package edu.fatec.carometro.repository;


import edu.fatec.carometro.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
	
}
