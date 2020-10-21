package br.com.alpoo.jogo.dao;

import br.com.alpoo.jogo.entity.Jogo;

public interface jogoDAO {

	public Jogo salva(Jogo jogo);
	
	public Jogo getJogoByUsuario(Integer usrCodigo);
	
}
