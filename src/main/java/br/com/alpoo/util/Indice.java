package br.com.alpoo.util;

public class Indice {
	private Integer line;
	private Integer column;
	
	public Indice(Integer line, Integer column) {
		super();
		this.line = line;
		this.column = column;
	}
	
	public Integer getLine() {
		return line;
	}
	public void setLine(Integer line) {
		this.line = line;
	}
	public Integer getColumn() {
		return column;
	}
	public void setColumn(Integer column) {
		this.column = column;
	}
	
}
