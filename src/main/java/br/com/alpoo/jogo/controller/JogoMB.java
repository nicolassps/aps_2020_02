package br.com.alpoo.jogo.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.alpoo.engine.TabuleiroUtils;
import br.com.alpoo.engine.enums.Movimento;
import br.com.alpoo.engine.exception.MovimentoException;

@Component (value = "jogoMB")
@Scope("view")
public class JogoMB {

	private Integer[][] tabuleiro;
	private List<Integer> listaTabuleiro;
	
	public JogoMB() {
		tabuleiro = TabuleiroUtils.initTabuleiro();
		listaTabuleiro = new ArrayList<Integer>();
		montaTabuleiro();
	}

	public void montaTabuleiro() {
		listaTabuleiro.clear();
		
		for (int i = 0; i < TabuleiroUtils.LINES; i++) {
			for (int j = 0; j < TabuleiroUtils.COLS; j++) {
				listaTabuleiro.add(tabuleiro[i][j]);
			}
		}
	}
	
	public void move(String direcao) {
		try {
			TabuleiroUtils.movimentoTabuleiro(tabuleiro, Movimento.valueOf(direcao.toUpperCase()));
			montaTabuleiro();
		} catch (MovimentoException e) {
			
		}
	}
	

	public Integer[][] getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(Integer[][] tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public List<Integer> getListaTabuleiro() {
		return listaTabuleiro;
	}

	public void setListaTabuleiro(List<Integer> listaTabuleiro) {
		this.listaTabuleiro = listaTabuleiro;
	}

}
