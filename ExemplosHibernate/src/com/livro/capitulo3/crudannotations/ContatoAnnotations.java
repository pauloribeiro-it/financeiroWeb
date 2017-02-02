package com.livro.capitulo3.crudannotations;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contato")
public class ContatoAnnotations {
	@Id
	@GeneratedValue
	@Column(name="codigo")
	private Integer codigo;
	
	@Column(name="nome",length=50,nullable=true)
	private String nome;
	
	@Column(name="telefone",length=50,nullable=true)
	private String telefone;
	
	@Column(name="email",length=50,nullable=true)
	private String email;
	
	@Column(name="dt_cad",nullable=true)
	private Date dataCadastro;
	
	@Column(name="obs",nullable=true)
	private String observacao;
	
	
	public final Integer getCodigo() {
		return codigo;
	}
	public final void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public final String getNome() {
		return nome;
	}
	public final void setNome(String nome) {
		this.nome = nome;
	}
	public final String getTelefone() {
		return telefone;
	}
	public final void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public final String getEmail() {
		return email;
	}
	public final void setEmail(String email) {
		this.email = email;
	}
	public final Date getDataCadastro() {
		return dataCadastro;
	}
	public final void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public final String getObservacao() {
		return observacao;
	}
	public final void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	
}
