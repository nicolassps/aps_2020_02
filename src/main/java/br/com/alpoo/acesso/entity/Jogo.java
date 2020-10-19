package br.com.alpoo.acesso.entity;

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

import org.primefaces.component.dashboard.Dashboard;

@Entity
@Table(name = "jogo", schema = "alpoo")
@SequenceGenerator(name = "JOGO_GENERATOR", sequenceName = "SEQ_JOGO", allocationSize = 1)
public class Jogo implements Serializable {

	private Integer jogCodigo;
	private Byte jogEstado;
	private Date jogDataCriacao;
	private Date jogDataAtualizacao;
	private Integer usrCodigo;
	
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
	public Byte getJogEstado() {
		return jogEstado;
	}
	public void setJogEstado(Byte jogEstado) {
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
	
	@ManyToOne(targetEntity = Usuario.class)
	@JoinColumn(name="usr_codigo", referencedColumnName = "usr_codigo")
	public Integer getUsrCodigo() {
		return usrCodigo;
	}
	public void setUsrCodigo(Integer usrCodigo) {
		this.usrCodigo = usrCodigo;
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
