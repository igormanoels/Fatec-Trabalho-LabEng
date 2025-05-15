package edu.fatec.carometro.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Usuario {
    @Id
    private String email;

    private String senha;
    private String nome;
    private String categoria;
    private boolean permissao;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Endereco endereco;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private PerfilUsuario perfil;

    @OneToMany(mappedBy = "usuario")
    private List<TipoAcessoUsuario> acessos;
    
    public Usuario(String em, String sn, String nm, String cat, boolean bl) {
    	this.email = em;
    	this.senha = sn;
    	this.nome = nm;
    	this.categoria = cat;
    	this.permissao = bl;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public boolean isPermissao() {
		return permissao;
	}

	public void setPermissao(boolean permissao) {
		this.permissao = permissao;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public PerfilUsuario getPerfilUsuario() {
		return perfil;
	}

	public void setPerfilUsuario(PerfilUsuario perfilUsuario) {
		this.perfil = perfilUsuario;
	}

    
}
