package edu.fatec.carometro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
