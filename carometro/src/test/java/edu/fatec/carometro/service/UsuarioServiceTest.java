package edu.fatec.carometro.service;

import edu.fatec.carometro.model.Usuario;
import edu.fatec.carometro.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsuarioServiceTest {

    private UsuarioRepository usuarioRepository;
    private UsuarioService usuarioService;

    @BeforeEach
    void setUp() {
        usuarioRepository = mock(UsuarioRepository.class);
        usuarioService = new UsuarioService(usuarioRepository);
    }

    @Test
    void deveSalvarUsuario() {
        Usuario usuario = new Usuario("joao@email.com", "1234", "João", "Aluno", true);
        when(usuarioRepository.save(usuario)).thenReturn(usuario);

        Usuario salvo = usuarioService.salvar(usuario);

        assertNotNull(salvo);
        assertEquals("joao@email.com", salvo.getEmail());
        verify(usuarioRepository, times(1)).save(usuario);
    }

    @Test
    void deveBuscarUsuarioPorEmail() {
        String email = "ana@email.com";
        Usuario usuario = new Usuario(email, "senha", "Ana", "Docente", true);
        when(usuarioRepository.findById(email)).thenReturn(Optional.of(usuario));

        Optional<Usuario> resultado = usuarioService.buscarPorEmail(email);

        assertTrue(resultado.isPresent());
        assertEquals("Ana", resultado.get().getNome());
    }

    @Test
    void deveBuscarTodosUsuarios() {
        Usuario u1 = new Usuario("a@a.com", "1", "A", "Aluno", true);
        Usuario u2 = new Usuario("b@b.com", "2", "B", "Aluno", true);
        when(usuarioRepository.findAll()).thenReturn(Arrays.asList(u1, u2));

        List<Usuario> usuarios = usuarioService.listarTodos();

        assertEquals(2, usuarios.size());
        verify(usuarioRepository, times(1)).findAll();
    }

    @Test
    void deveDeletarUsuarioPorEmail() {
        String email = "usuario@email.com";
        doNothing().when(usuarioRepository).deleteById(email);

        usuarioService.deletar(email);

        verify(usuarioRepository, times(1)).deleteById(email);
    }
}
