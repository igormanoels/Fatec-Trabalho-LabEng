package edu.fatec.carometro.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class TipoAcesso {
    @Id
    private Integer id;
    private String nivel;

    @OneToMany(mappedBy = "tipoAcesso")
    private List<TipoAcessoUsuario> usuarios;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public List<TipoAcessoUsuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<TipoAcessoUsuario> usuarios) {
		this.usuarios = usuarios;
	}
    
    
}