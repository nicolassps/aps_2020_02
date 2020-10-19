package br.com.alpoo.engine;

import br.com.alpoo.engine.enums.Movimento;

public class Main {

	public static void main(String[] args) {
		Integer[][] tab = TabuleiroUtils.initTabuleiro();
		
		for (Integer[] integers : tab) {
			
			for (Integer i : integers) {
				System.out.print(i + " | ");
			}
			
			System.out.println("");
			
			System.out.println("----------------------");
		}
		
		System.out.println();
		System.out.println("MOVIMENTOS PERMITIDOS:");
		
		for (Movimento mov : TabuleiroUtils.movimentosPermitidos(tab)) {
			System.out.println(mov.toString());
		}
	}

}
