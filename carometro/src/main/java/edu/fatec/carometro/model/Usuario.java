package edu.fatec.carometro.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Usuario {
    @Id
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;
    
    private String nome;
    private String categoria;
    private boolean permissao;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Endereco endereco;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private PerfilUsuario perfil;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TipoAcessoUsuario> acessos;
    
    // Construtores
    public Usuario() {}
    
    public Usuario(String email, String senha, String nome, String categoria, boolean permissao) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.categoria = categoria;
        this.permissao = permissao;
    }   
   
    // Equals e HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return email.equals(usuario.email);
    }

    // Getters e Setters
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

	public PerfilUsuario getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilUsuario perfil) {
		this.perfil = perfil;
	}

	public List<TipoAcessoUsuario> getAcessos() {
		return acessos;
	}

	public void setAcessos(List<TipoAcessoUsuario> acessos) {
		this.acessos = acessos;
	}

	@Override
    public int hashCode() {
        return Objects.hash(email);
    }
}