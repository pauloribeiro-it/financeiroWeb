package financeiro.bolsa.acao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import financeiro.usuario.Usuario;

@Entity
@Table(name="acao")
public class Acao implements Serializable{

	private static final long serialVersionUID = 19992980422943254L;
	
	@Id
	@GeneratedValue
	@Column(name="cod_acao")
	private Integer codigo;
	
	@Column(nullable=false, length=10)
	private String sigla;
	
	@Column(length=30)
	private String descricao;
	
	@Column(nullable=false)
	private Integer quantidade;
	
	@Column(nullable=false,length=1)
	private Character origem;
	
	@ManyToOne
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Usuario usuario;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Character getOrigem() {
		return origem;
	}

	public void setOrigem(Character origem) {
		this.origem = origem;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
