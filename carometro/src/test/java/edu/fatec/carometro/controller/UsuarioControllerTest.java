package edu.fatec.carometro.controller;

import edu.fatec.carometro.model.Usuario;
import edu.fatec.carometro.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;
import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioService usuarioService;

    private Usuario usuario;

    @BeforeEach
    void setUp() {
        usuario = new Usuario("teste@email.com", "123", "Aluno", "Estudante", true);
    }

    @Test
    void deveRetornarTodosUsuarios() throws Exception {
        when(usuarioService.listarTodos()).thenReturn(Arrays.asList(usuario));

        mockMvc.perform(get("/usuarios"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].email").value("teste@email.com"));
    }

    @Test
    void deveRetornarUsuarioPorEmail() throws Exception {
        when(usuarioService.buscarPorEmail("teste@email.com")).thenReturn(Optional.of(usuario));

        mockMvc.perform(get("/usuarios/teste@email.com"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Teste"));
    }

    @Test
    void deveSalvarUsuario() throws Exception {
        when(usuarioService.salvar(any(Usuario.class))).thenReturn(usuario);

        mockMvc.perform(post("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(usuario)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("teste@email.com"));
    }
/*
    @Test
    void deveAtualizarUsuario() throws Exception {
        when(usuarioService.atualizar(anyString(), any(Usuario.class))).thenReturn(Optional.of(usuario));

        mockMvc.perform(put("/usuarios/teste@email.com")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(usuario)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Teste"));
    }
*/
    @Test
    void deveDeletarUsuario() throws Exception {
        doNothing().when(usuarioService).deletar("teste@email.com");

        mockMvc.perform(delete("/usuarios/teste@email.com"))
                .andExpect(status().isNoContent());
    }
}
