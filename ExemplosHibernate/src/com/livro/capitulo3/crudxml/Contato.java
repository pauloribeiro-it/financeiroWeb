package com.livro.capitulo3.crudxml;

import java.sql.Date;

public class Contato {
	private Integer codigo;
	private String nome;
	private String telefone;
	private String email;
	private Date dataCadastro;
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
