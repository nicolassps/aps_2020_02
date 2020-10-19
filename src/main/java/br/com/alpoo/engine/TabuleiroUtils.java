package br.com.alpoo.engine;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.util.Pair;

import br.com.alpoo.engine.enums.Movimento;
import br.com.alpoo.engine.exception.MovimentoException;
import br.com.alpoo.util.Indice;
import br.com.alpoo.util.MensagemEnum;
import br.com.alpoo.util.NumberUtil;

public class TabuleiroUtils {
	public static final Integer LINES = 3;
	public static final Integer COLS = 3;

	public static Integer[][] initTabuleiro() {
		Integer[][] t = new Integer[LINES][COLS];
		
		for (int i = 0; i < LINES; i++) {
			for (int j = 0; j < COLS; j++) {
				do {
					Integer numero = NumberUtil.randomNumber(8);
					
					t[i][j] = NumberUtil.isOnList(t, numero) ? null : numero;
				} while(t[i][j] == null);
			}
		}
		
		return t;
	}
	
	public static Integer[][] movimentoTabuleiro(Integer[][] tabuleiro, Movimento movimento) throws MovimentoException{
		if(!isMovimentoPermitido(tabuleiro, movimento)) {
			throw new MovimentoException(MensagemEnum.MENSAGEM_MOVIMENTO_ILEGAL.value(), movimento, movimentosPermitidos(tabuleiro));
		}
		
		Indice origem = coordenadaMovimentacao(tabuleiro);
		Indice destino = new Indice(origem.getLine() + movimento.getL(), origem.getColumn() + movimento.getC()); 
		
		
		return tabuleiro;
	}
	
	public static Integer[][] alteraValor(Integer[][] tabuleiro, Indice indice, Integer valor){
		tabuleiro[indice.getLine()][indice.getColumn()] = valor;
		
		return tabuleiro;
	}
	
	public static Boolean isMovimentoPermitido(Integer[][] tabuleiro, Movimento movimento) {
		return movimentosPermitidos(tabuleiro).contains(movimento);
	}
	
	public static List<Movimento> movimentosPermitidos(Integer[][] tabuleiro){
		List<Movimento> movimentosPermitidos = new ArrayList<Movimento>();
		
		Indice i = coordenadaMovimentacao(tabuleiro);
		
 		for (Movimento movimento : Movimento.values()) {
			Indice destinoMovimento = coordenadaFinalMovimento(i, movimento);
			
			if((destinoMovimento.getLine() >= 0 && destinoMovimento.getLine() < LINES) 
					&&	(destinoMovimento.getColumn() >= 0 && destinoMovimento.getColumn() < COLS)) {
				
				movimentosPermitidos.add(movimento);
			}
		}
		
		return movimentosPermitidos;
	}
	
	/**
	 * @return Retorna um par de coordenada de onde o objeto com valor 0 está.
	 * */
	private static Indice coordenadaMovimentacao(Integer[][] tabuleiro){
		Integer lineMovimento = null;
		Integer colMovimento = null;
		
		for (int i = 0; i < LINES; i++) {
			for (int j = 0; j < COLS; j++) {
				if(lineMovimento != null && colMovimento != null) {
					break;
				}
				
				lineMovimento = tabuleiro[i][j].equals(0) ? i : null; 		
				colMovimento = tabuleiro[i][j].equals(0) ? j : null; 
			}
		}
		
		return new Indice(lineMovimento, colMovimento);
	}
	
	/**
	 * @return Retorna um par de coordenada de onde o objeto irá com o movimento
	 * 
	 * @param indice A ser movimentado
	 * 
	 * @param movimento Para onde o objeto vai
	 * */
	private static Indice coordenadaFinalMovimento(Indice origem, Movimento movimento){
		return new Indice(origem.getLine() + movimento.getL(), origem.getColumn() + movimento.getC()); 
	}
}
