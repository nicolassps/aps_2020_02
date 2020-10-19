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
@Table(name = "pergunta", schema = "alpoo")
@SequenceGenerator(name = "PERGUNTA_GENERATOR", sequenceName = "SEQ_PERGUNTA", allocationSize = 1)
public class PerguntaSeguranca implements Serializable{

	private static final long serialVersionUID = 1340111959848797256L;
	private Integer pesCodigo;
	private String pesPergunta;
	private String pesResposta;
	
	@Id
	@Column(name="per_codigo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERGUNTA_GENERATOR")	
	public Integer getPesCodigo() {
		return pesCodigo;
	}
	public void setPesCodigo(Integer pesCodigo) {
		this.pesCodigo = pesCodigo;
	}
	
	@Column(name="pes_pergunta")
	public String getPesPergunta() {
		return pesPergunta;
	}
	public void setPesPergunta(String pesPergunta) {
		this.pesPergunta = pesPergunta;
	}
	@Column(name="pes_resposta")
	public String getPesResposta() {
		return pesResposta;
	}
	public void setPesResposta(String pesResposta) {
		this.pesResposta = pesResposta;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pesCodigo == null) ? 0 : pesCodigo.hashCode());
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
		PerguntaSeguranca other = (PerguntaSeguranca) obj;
		if (pesCodigo == null) {
			if (other.pesCodigo != null)
				return false;
		} else if (!pesCodigo.equals(other.pesCodigo))
			return false;
		return true;
	}
	
}
