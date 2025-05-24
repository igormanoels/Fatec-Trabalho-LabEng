package edu.fatec.carometro.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class TipoAcessoUsuarioId implements Serializable {
    private Integer tipoAcessoId;
    private String usuarioEmail;
    
    public Integer getTipoAcessoId() {
        return tipoAcessoId;
    }

    public void setTipoAcessoId(Integer tipoAcessoId) {
        this.tipoAcessoId = tipoAcessoId;
    }

    public String getUsuarioEmail() {
        return usuarioEmail;
    }

    public void setUsuarioEmail(String usuarioEmail) {
        this.usuarioEmail = usuarioEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoAcessoUsuarioId)) return false;
        TipoAcessoUsuarioId that = (TipoAcessoUsuarioId) o;
        return Objects.equals(tipoAcessoId, that.tipoAcessoId) &&
               Objects.equals(usuarioEmail, that.usuarioEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoAcessoId, usuarioEmail);
    }
}
