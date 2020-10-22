package br.com.alpoo.acesso.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.alpoo.jogo.entity.PerguntaSeguranca;


@Entity
@Table(name = "usuario", schema = "alpoo")
@SequenceGenerator(name = "USUARIO_GENERATOR2", sequenceName = "SEQ_USUARIO", allocationSize = 1)
public class Usuario implements Serializable{

	private static final long serialVersionUID = -7344924069577208005L;
	private Integer usrCodigo;
	private String usrNome;
	private String usrLogin;
	private String usrSenha;
	private PerguntaSeguranca perguntaSeguranca;
	private String usrRespostaSeguranca;
	
	public Usuario() {
		this.perguntaSeguranca = new PerguntaSeguranca();
	}
	
	@Id
	@Column(name="usr_codigo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_GENERATOR2")	
	public Integer getUsrCodigo() {
		return usrCodigo;
	}
	public void setUsrCodigo(Integer usrCodigo) {
		this.usrCodigo = usrCodigo;
	}
	
	@Column(name="usr_name")
	public String getUsrNome() {
		return usrNome;
	}
	public void setUsrNome(String usrNome) {
		this.usrNome = usrNome;
	}
	
	@Column(name="usr_login")
	public String getUsrLogin() {
		return usrLogin;
	}
	public void setUsrLogin(String usrLogin) {
		this.usrLogin = usrLogin;
	}
	
	@Column(name="usr_senha")
	public String getUsrSenha() {
		return usrSenha;
	}
	public void setUsrSenha(String usrSenha) {
		this.usrSenha = usrSenha;
	}
	
	@ManyToOne
	@JoinColumn(name="per_codigo")
	public PerguntaSeguranca getPerguntaSeguranca() {
		return perguntaSeguranca;
	}
	public void setPerguntaSeguranca(PerguntaSeguranca perguntaSeguranca) {
		this.perguntaSeguranca = perguntaSeguranca;
	}
	
	
	@Column(name="usr_resposta_seguranca")
	public String getUsrRespostaSeguranca() {
		return usrRespostaSeguranca;
	}
	public void setUsrRespostaSeguranca(String usrRespostaSeguranca) {
		this.usrRespostaSeguranca = usrRespostaSeguranca;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usrCodigo == null) ? 0 : usrCodigo.hashCode());
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
		Usuario other = (Usuario) obj;
		if (usrCodigo == null) {
			if (other.usrCodigo != null)
				return false;
		} else if (!usrCodigo.equals(other.usrCodigo))
			return false;
		return true;
	}
	
}
