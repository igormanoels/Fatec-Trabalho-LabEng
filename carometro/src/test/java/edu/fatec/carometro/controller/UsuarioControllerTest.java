package edu.fatec.carometro.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.fatec.carometro.model.Usuario;
import edu.fatec.carometro.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioService usuarioService;

    @Autowired
    private ObjectMapper objectMapper;

    private Usuario usuario;

    @BeforeEach
    void setup() {
        usuario = new Usuario();
        usuario.setEmail("igor@teste.com");
        usuario.setNome("Igor");
    }

    @Test
    void deveCriarUsuario() throws Exception {
        Mockito.when(usuarioService.salvar(any(Usuario.class))).thenReturn(usuario);

        mockMvc.perform(post("/api/usuarios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(usuario)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email", is(usuario.getEmail())))
                .andExpect(jsonPath("$.nome", is(usuario.getNome())));
    }

    @Test
    void deveAtualizarUsuario() throws Exception {
        Mockito.when(usuarioService.buscarPorEmail(eq(usuario.getEmail())))
                .thenReturn(java.util.Optional.of(usuario));
        Mockito.when(usuarioService.salvar(any(Usuario.class))).thenReturn(usuario);

        mockMvc.perform(put("/api/usuarios/{email}", usuario.getEmail())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(usuario)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email", is(usuario.getEmail())))
                .andExpect(jsonPath("$.nome", is(usuario.getNome())));
    }
}
