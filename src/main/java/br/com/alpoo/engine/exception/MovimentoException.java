package br.com.alpoo.engine.exception;

import java.util.List;

import br.com.alpoo.engine.enums.Movimento;

public class MovimentoException extends Exception {
	private static final long serialVersionUID = -233303483303546044L;
	private Movimento tentativaMovimento;
	private List<Movimento> movimentosPermitidos;
	
	public MovimentoException() {
		super();
	}

	public MovimentoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MovimentoException(String message, Throwable cause) {
		super(message, cause);
	}

	public MovimentoException(String message) {
		super(message);
	}

	public MovimentoException(Throwable cause) {
		super(cause);
	}
	
	public MovimentoException(String message, Movimento tentativaMovimento, List<Movimento> movimentosPermitidos) {
		super(message);
		
		this.tentativaMovimento = tentativaMovimento;
		this.movimentosPermitidos = movimentosPermitidos;
	}

	public Movimento getTentativaMovimento() {
		return tentativaMovimento;
	}

	public void setTentativaMovimento(Movimento tentativaMovimento) {
		this.tentativaMovimento = tentativaMovimento;
	}

	public List<Movimento> getMovimentosPermitidos() {
		return movimentosPermitidos;
	}

	public void setMovimentosPermitidos(List<Movimento> movimentosPermitidos) {
		this.movimentosPermitidos = movimentosPermitidos;
	}
	
}	
