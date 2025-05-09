package edu.fatec.carometro.model;

import java.io.Serializable;

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
    
}