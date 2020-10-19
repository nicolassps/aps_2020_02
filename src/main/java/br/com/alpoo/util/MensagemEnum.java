package br.com.alpoo.util;

public enum MensagemEnum {
	MENSAGEM_MOVIMENTO_ILEGAL("MOVIMENTAÇÃO ILEGAL, TENTE NOVAMENTE");

	String mensagem;
	
	private MensagemEnum(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public String value() {
		return mensagem;
	}
}
