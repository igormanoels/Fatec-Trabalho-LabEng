package edu.fatec.carometro.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class TipoAcessoUsuario {
    @EmbeddedId
    private TipoAcessoUsuarioId id;

    @ManyToOne
    @MapsId("tipoAcessoId")
    private TipoAcesso tipoAcesso;

    @ManyToOne
    @MapsId("usuarioEmail")
    private Usuario usuario;
}

