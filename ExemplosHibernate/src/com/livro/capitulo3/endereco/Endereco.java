package com.livro.capitulo3.endereco;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;
import org.hibernate.annotations.Parameter;

import com.livro.capitulo3.cliente.Cliente;

@Entity
@Table(name="endereco")
public class Endereco implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 573616983979590321L;

	@Id
	@GeneratedValue(generator = "fk_endereco_cod_cliente")
	@org.hibernate.annotations.GenericGenerator(name="fk_endereco_cod_cliente",strategy="foreign",parameters=@Parameter(name="property",value="cliente"))
	@Column(name="cod_cliente")
	
	private Integer endereco;
	@OneToOne(mappedBy="endereco")
	private Cliente cliente;
	private String rua;
	private Integer numero;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;
	private String complemento;
	public final Integer getEndereco() {
		return endereco;
	}
	public final void setEndereco(Integer endereco) {
		this.endereco = endereco;
	}
	public final Cliente getCliente() {
		return cliente;
	}
	public final void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public final String getRua() {
		return rua;
	}
	public final void setRua(String rua) {
		this.rua = rua;
	}
	public final Integer getNumero() {
		return numero;
	}
	public final void setNumero(Integer numero) {
		this.numero = numero;
	}
	public final String getBairro() {
		return bairro;
	}
	public final void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public final String getCidade() {
		return cidade;
	}
	public final void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public final String getUf() {
		return uf;
	}
	public final void setUf(String uf) {
		this.uf = uf;
	}
	public final String getCep() {
		return cep;
	}
	public final void setCep(String cep) {
		this.cep = cep;
	}
	public final String getComplemento() {
		return complemento;
	}
	public final void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result
				+ ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result
				+ ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((rua == null) ? 0 : rua.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
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
		Endereco other = (Endereco) obj;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (rua == null) {
			if (other.rua != null)
				return false;
		} else if (!rua.equals(other.rua))
			return false;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		return true;
	}
	
	
}
