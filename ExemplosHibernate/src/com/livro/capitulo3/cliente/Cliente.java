package com.livro.capitulo3.cliente;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.livro.capitulo3.endereco.Endereco;
import com.livro.capitulo3.locacao.Locacao;

@Entity
@Table(name="cliente")
public class Cliente implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4221024182875784072L;

	@Id
	@GeneratedValue
	@Column(name="cod_cliente")
	private Integer cliente;
	
	@OneToOne
	@PrimaryKeyJoinColumn(name="cod_cliente")
	private Endereco endereco;
	
	@OneToMany(mappedBy="cliente")
	//@JoinColumn(name="id_cliente")
	private List<Locacao> locacoes;
	
	private String nome;
	private String telefone;
	private String celular;
	private String email;
	
	public final Integer getCliente() {
		return cliente;
	}
	public final void setCliente(Integer cliente) {
		this.cliente = cliente;
	}
	public final Endereco getEndereco() {
		return endereco;
	}
	public final void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public final List<Locacao> getLocacoes() {
		return locacoes;
	}
	public final void setLocacoes(List<Locacao> locacoes) {
		this.locacoes = locacoes;
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
	public final String getCelular() {
		return celular;
	}
	public final void setCelular(String celular) {
		this.celular = celular;
	}
	public final String getEmail() {
		return email;
	}
	public final void setEmail(String email) {
		this.email = email;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result
				+ ((locacoes == null) ? 0 : locacoes.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (celular == null) {
			if (other.celular != null)
				return false;
		} else if (!celular.equals(other.celular))
			return false;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (locacoes == null) {
			if (other.locacoes != null)
				return false;
		} else if (!locacoes.equals(other.locacoes))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}
	
	
}
