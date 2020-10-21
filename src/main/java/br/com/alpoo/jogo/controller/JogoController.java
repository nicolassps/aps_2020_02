package br.com.alpoo.jogo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.alpoo.acesso.entity.Usuario;
import br.com.alpoo.acesso.service.UsuarioService;
import br.com.alpoo.engine.TabuleiroUtils;
import br.com.alpoo.engine.enums.Movimento;
import br.com.alpoo.engine.exception.MovimentoException;
import br.com.alpoo.jogo.entity.Jogo;
import br.com.alpoo.jogo.service.JogoService;

@Component (value = "jogoController")
@Scope("view")
public class JogoController {

	private Integer[][] tabuleiro;
	private List<Integer> listaTabuleiro;
	private Usuario usuario;
	private Jogo jogo;
	
	public JogoController() {
	
	}
	
	@Autowired
	private JogoService jogoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostConstruct
	private void Inicializa() {
		tabuleiro = TabuleiroUtils.initTabuleiro();
		usuario = usuarioService.getById(1);
		jogo = jogoService.getJogoByUsuario(1);
		if(jogo == null) {
			listaTabuleiro = new ArrayList<Integer>();
		}else {
			listaTabuleiro = jogoService.retornaListaJogo(jogo.getJogEstado());
		}
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
	
	public void salvaJogo() {
		try {
			jogo = jogoService.salva(listaTabuleiro, usuario);
		} catch (Exception e) {
			e.printStackTrace();
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
