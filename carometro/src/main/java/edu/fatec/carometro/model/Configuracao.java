package edu.fatec.carometro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Configuracao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private boolean modoNoturno;

    @OneToOne
    @JoinColumn(name = "perfilUsuarioId")
    private PerfilUsuario perfilUsuario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isModoNoturno() {
		return modoNoturno;
	}

	public void setModoNoturno(boolean modoNoturno) {
		this.modoNoturno = modoNoturno;
	}

	public PerfilUsuario getPerfilUsuario() {
		return perfilUsuario;
	}

	public void setPerfilUsuario(PerfilUsuario perfilUsuario) {
		this.perfilUsuario = perfilUsuario;
	}
    
    
}

