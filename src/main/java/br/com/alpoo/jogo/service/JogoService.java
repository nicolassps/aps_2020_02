package br.com.alpoo.jogo.service;

import java.util.List;

import br.com.alpoo.acesso.entity.Usuario;
import br.com.alpoo.jogo.entity.Jogo;

public interface JogoService {

	public Jogo salva(List<Integer> tabuleiro, Usuario usuario, Jogo jogo, Boolean reiniciar);
	
	public Jogo getJogoByUsuario(Integer usrCodigo);
	
	public List<Integer> retornaListaJogo(byte[] estadoJogo);
	
}
