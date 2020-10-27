package br.com.alpoo.jogo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.alpoo.acesso.entity.Usuario;
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
	private Boolean jogoEncerrado;
	private Boolean jogoReiniciado;
	
	public JogoController() {
		jogoReiniciado = false;
	}
	
	@Autowired
	private JogoService jogoService;
	
	@Autowired
	private SessaoController sessaoController;
	
	@PostConstruct
	private void inicializa() {
		jogoEncerrado = false;
		tabuleiro = TabuleiroUtils.initTabuleiro();
		usuario = sessaoController.getUsuarioLogado();
		
		jogo = jogoService.getJogoByUsuario(usuario.getUsrCodigo());
		if(jogo != null && jogo.getJogEstado() != null) {
			
			listaTabuleiro = jogoService.retornaListaJogo(jogo.getJogEstado());
			
			int k = 0;
			for (int i = 0; i < TabuleiroUtils.LINES; i++) {
				for (int j = 0; j < TabuleiroUtils.COLS; j++) {
					tabuleiro[i][j] = listaTabuleiro.get(k);
					k++;
				}
			}
			montaTabuleiro();
			
		}else {
			listaTabuleiro = new ArrayList<Integer>();
			montaTabuleiro();
			
		}
	}

	public void montaTabuleiro() {
		listaTabuleiro.clear();
		
		for (int i = 0; i < TabuleiroUtils.LINES; i++) {
			for (int j = 0; j < TabuleiroUtils.COLS; j++) {
				listaTabuleiro.add(tabuleiro[i][j]);
			}
		}
		encerraJogo();
	}
	
	public void move(String direcao) {
		try {
 			tabuleiro = TabuleiroUtils.movimentoTabuleiro(tabuleiro, Movimento.valueOf(direcao.toUpperCase()));
			montaTabuleiro();
		} catch (MovimentoException e) {
			
		}
	}
	
	public void salvaJogo() {
		try {
			jogo = jogoService.salva(listaTabuleiro, usuario, jogo, jogoReiniciado);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("IESGF", "Jogo salvo"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Boolean encerraJogo() {
		jogoEncerrado = TabuleiroUtils.jogoEncerrado(tabuleiro);
		
		if(jogoEncerrado) {
			salvaJogo();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("IESGF", "Jogo concluido"));
			org.primefaces.context.RequestContext.getCurrentInstance().update("frmJogo");
		}
		
		return jogoEncerrado;
	}
	
	public void reiniciaJogo() {
		tabuleiro = TabuleiroUtils.initTabuleiro();
		montaTabuleiro();
		org.primefaces.context.RequestContext.getCurrentInstance().update("frmJogo");
		jogoReiniciado = true;
		
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public Boolean getJogoEncerrado() {
		return jogoEncerrado;
	}

	public void setJogoEncerrado(Boolean jogoEncerrado) {
		this.jogoEncerrado = jogoEncerrado;
	}

}
