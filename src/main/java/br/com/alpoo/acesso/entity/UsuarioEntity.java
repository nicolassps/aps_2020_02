package br.com.alpoo.acesso.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="usuario", schema = "acesso")
@SequenceGenerator(name = "USUARIO_GENERATOR",  sequenceName = "SEQ_USUARIO", allocationSize = 1)
public class UsuarioEntity implements Serializable{
	private static final long serialVersionUID = -8423804997577907044L;
	private Integer usrCodigo;
	private String usrLogin;
	private String usrNome;
	private String usrSenha;
	private String usrEmail;
	private String usrCpf;
	
	@Id
	@GeneratedValue(generator = "USUARIO_GENERATOR", strategy = GenerationType.SEQUENCE)
	@Column(name="usr_codigo")
	public Integer getUsrCodigo() {
		return usrCodigo;
	}
	public void setUsrCodigo(Integer usrCodigo) {
		this.usrCodigo = usrCodigo;
	}
	
	@Column(name="usr_login")
	public String getUsrLogin() {
		return usrLogin;
	}
	public void setUsrLogin(String usrLogin) {
		this.usrLogin = usrLogin;
	}
	
	@Column(name="usr_nome")
	public String getUsrNome() {
		return usrNome;
	}
	public void setUsrNome(String usrNome) {
		this.usrNome = usrNome;
	}
	
	@Column(name="usr_senha")
	public String getUsrSenha() {
		return usrSenha;
	}
	public void setUsrSenha(String usrSenha) {
		this.usrSenha = usrSenha;
	}
	
	@Column(name="usr_email")
	public String getUsrEmail() {
		return usrEmail;
	}
	public void setUsrEmail(String usrEmail) {
		this.usrEmail = usrEmail;
	}
	
	@Column(name="usr_cpf")
	public String getUsrCpf() {
		return usrCpf;
	}
	public void setUsrCpf(String usrCpf) {
		this.usrCpf = usrCpf;
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
		UsuarioEntity other = (UsuarioEntity) obj;
		if (usrCodigo == null) {
			if (other.usrCodigo != null)
				return false;
		} else if (!usrCodigo.equals(other.usrCodigo))
			return false;
		return true;
	}
	
	
}
