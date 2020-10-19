package br.com.alpoo.engine;

import br.com.alpoo.engine.enums.Movimento;
import br.com.alpoo.engine.exception.MovimentoException;

public class Main {

	public static void main(String[] args) {
		Integer[][] tab = TabuleiroUtils.initTabuleiro();
		
		imprime(tab);
		
		System.out.println();
		System.out.println("MOVIMENTOS PERMITIDOS:");
		
		for (Movimento mov : TabuleiroUtils.movimentosPermitidos(tab)) {
			System.out.println(mov.toString());
		}
		
		try {
			tab = TabuleiroUtils.movimentoTabuleiro(tab, Movimento.BAIXO);
			imprime(tab);
		} catch (MovimentoException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void imprime(Integer[][] tab) {
		for (Integer[] integers : tab) {
			
			for (Integer i : integers) {
				System.out.print(i + " | ");
			}
			
			System.out.println("");
			
			System.out.println("----------------------");
		}
	}

}
