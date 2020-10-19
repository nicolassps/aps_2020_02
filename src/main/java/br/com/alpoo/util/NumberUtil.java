package br.com.alpoo.util;

import java.util.Random;

public class NumberUtil {
	private static final Random RANDOM = new Random();
	
	public static Boolean isOnList(Integer[][] tabuleiro, Integer numero) {
		for (Integer[] linha : tabuleiro) {
			for (Integer item : linha) {
				if(item != null && item.equals(numero)) {
					return Boolean.TRUE;
				}
			}
		}
		
		return Boolean.FALSE;
	}

	public static Integer randomNumber(Integer max) {
		return NumberUtil.randomNumber(null, max);
	} 
	
	public static Integer randomNumber(Integer min, Integer max) {
		min = min == null ? 0 : min;
		
		return RANDOM.nextInt((max - min) + 1) + min;
	}
}
