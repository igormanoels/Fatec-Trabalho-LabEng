package edu.fatec.carometro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class EmpresaParceira {
    @Id
    private String cnpj;

    private Integer nomeResponsavel;

    @OneToOne
    @JoinColumn(name = "cnpj")
    private PessoaJuridica pessoaJuridica;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Integer getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(Integer nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}
    
    
}