package br.com.alpoo.jogo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.alpoo.acesso.entity.Usuario;

@Entity
@Table(name = "jogo", schema = "alpoo")
@SequenceGenerator(name = "JOGO_GENERATOR", sequenceName = "SEQ_JOGO", allocationSize = 1)
public class Jogo implements Serializable {

	private static final long serialVersionUID = 5921163327127610221L;
	
	private Integer jogCodigo;
	private byte[] jogEstado;
	private Date jogDataCriacao;
	private Date jogDataAtualizacao;
	private Usuario usuario;
	
	@Id
	@Column(name="jog_codigo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JOGO_GENERATOR")	
	public Integer getJogCodigo() {
		return jogCodigo;
	}
	
	public void setJogCodigo(Integer jogCodigo) {
		this.jogCodigo = jogCodigo;
	}
	
	@Column(name="jog_estado")
	public byte[] getJogEstado() {
		return jogEstado;
	}
	public void setJogEstado(byte[] jogEstado) {
		this.jogEstado = jogEstado;
	}
	
	@Column(name="jog_data_criacao")
	public Date getJogDataCriacao() {
		return jogDataCriacao;
	}
	public void setJogDataCriacao(Date jogDataCriacao) {
		this.jogDataCriacao = jogDataCriacao;
	}
	
	@Column(name="jog_data_atualizacao")
	public Date getJogDataAtualizacao() {
		return jogDataAtualizacao;
	}
	public void setJogDataAtualizacao(Date jogDataAtualizacao) {
		this.jogDataAtualizacao = jogDataAtualizacao;
	}
	
	@ManyToOne
	@JoinColumn(name="usr_codigo")
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jogCodigo == null) ? 0 : jogCodigo.hashCode());
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
		Jogo other = (Jogo) obj;
		if (jogCodigo == null) {
			if (other.jogCodigo != null)
				return false;
		} else if (!jogCodigo.equals(other.jogCodigo))
			return false;
		return true;
	}
	
	
}
