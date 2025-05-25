package edu.fatec.carometro.controller;

import java.util.List;
import java.util.Optional;

import edu.fatec.carometro.dto.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.fatec.carometro.model.Usuario;
import edu.fatec.carometro.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioService.salvar(usuario);
        return ResponseEntity.ok(novoUsuario);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest login) {
        Optional<Usuario> usuario = usuarioService.buscarPorEmail(login.getEmail());

        if (usuario.isPresent() && usuario.get().getSenha().equals(login.getSenha())) {
            return ResponseEntity.ok(usuario.get());
        }

        return ResponseEntity.status(401).body("Credenciais inválidas");
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.listarTodos());
    }

    @GetMapping("/{email}")
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable String email) {
        return usuarioService.buscarPorEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{email}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable String email, @RequestBody Usuario usuarioAtualizado) {
        return usuarioService.buscarPorEmail(email)
                .map(usuarioExistente -> {
                    usuarioAtualizado.setEmail(email);
                    Usuario atualizado = usuarioService.salvar(usuarioAtualizado);
                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable String email) {
        if (usuarioService.buscarPorEmail(email).isPresent()) {
            usuarioService.deletar(email);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
