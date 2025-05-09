package edu.fatec.carometro.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class PerfilUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer identificador;

    private String sobreUsuario;
    private Integer totalCurtidas;
    private Integer visualizacoes;

    @OneToOne
    @JoinColumn(name = "usuarioEmail")
    private Usuario usuario;

    @OneToMany(mappedBy = "perfilUsuario")
    private List<FormacaoAcademica> formacoes;

    @OneToMany(mappedBy = "perfilUsuario")
    private List<Certificados> certificados;

    @OneToMany(mappedBy = "perfilUsuario")
    private List<ExperienciaProfissional> experiencias;

    @OneToMany(mappedBy = "perfilUsuario")
    private List<InformacoesAdicionais> informacoes;

    @OneToMany(mappedBy = "perfilUsuario")
    private List<RedesSociais> redesSociais;

    @OneToMany(mappedBy = "perfilUsuario")
    private List<Imagem> imagens;

    @OneToMany(mappedBy = "perfilUsuario")
    private List<Comentario> comentarios;

    @OneToOne(mappedBy = "perfilUsuario")
    private Configuracao configuracao;

	public Integer getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	public String getSobreUsuario() {
		return sobreUsuario;
	}

	public void setSobreUsuario(String sobreUsuario) {
		this.sobreUsuario = sobreUsuario;
	}

	public Integer getTotalCurtidas() {
		return totalCurtidas;
	}

	public void setTotalCurtidas(Integer totalCurtidas) {
		this.totalCurtidas = totalCurtidas;
	}

	public Integer getVisualizacoes() {
		return visualizacoes;
	}

	public void setVisualizacoes(Integer visualizacoes) {
		this.visualizacoes = visualizacoes;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<FormacaoAcademica> getFormacoes() {
		return formacoes;
	}

	public void setFormacoes(List<FormacaoAcademica> formacoes) {
		this.formacoes = formacoes;
	}

	public List<Certificados> getCertificados() {
		return certificados;
	}

	public void setCertificados(List<Certificados> certificados) {
		this.certificados = certificados;
	}

	public List<ExperienciaProfissional> getExperiencias() {
		return experiencias;
	}

	public void setExperiencias(List<ExperienciaProfissional> experiencias) {
		this.experiencias = experiencias;
	}

	public List<InformacoesAdicionais> getInformacoes() {
		return informacoes;
	}

	public void setInformacoes(List<InformacoesAdicionais> informacoes) {
		this.informacoes = informacoes;
	}

	public List<RedesSociais> getRedesSociais() {
		return redesSociais;
	}

	public void setRedesSociais(List<RedesSociais> redesSociais) {
		this.redesSociais = redesSociais;
	}

	public List<Imagem> getImagens() {
		return imagens;
	}

	public void setImagens(List<Imagem> imagens) {
		this.imagens = imagens;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Configuracao getConfiguracao() {
		return configuracao;
	}

	public void setConfiguracao(Configuracao configuracao) {
		this.configuracao = configuracao;
	}
    
    
    
}