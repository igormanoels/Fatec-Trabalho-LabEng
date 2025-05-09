package edu.fatec.carometro.service;

import edu.fatec.carometro.model.Usuario;
import edu.fatec.carometro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }
    
    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarioRepository.findById(email);
    }

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deletar(String email) {
        usuarioRepository.deleteById(email);
    }
}