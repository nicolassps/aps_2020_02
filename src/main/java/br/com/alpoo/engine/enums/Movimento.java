package br.com.alpoo.engine.enums;

public enum Movimento {
	DIREITA(0,1), 
	ESQUERDA(0,-1),
	CIMA(-1,0),
	BAIXO(1,0);

	/**
	 * {@value Valor de L se refere a quantidade de posições em Linha que deverá se deslocar no movimento} 
	 */
	Integer l;
	
	/**
	 * {@value Valor de C se refere a quantidade de posições em Coluna que deverá se deslocar no movimento} 
	 */
	Integer c;
	
	private Movimento(Integer l, Integer c) {
		this.l = l;
		this.c = c;
	}
	
	/** 
	 * @return Retorna o valor de linhas que deverá ser deslocado no movimento
	 * */
	public Integer getL() {
		return l;
	}
	
	/** 
	 * @return Retorna o valor de colunas que deverá ser deslocado no movimento
	 * */
	public Integer getC() {
		return c;
	}
	
}
