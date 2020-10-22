package br.com.alpoo.jogo.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alpoo.acesso.entity.Usuario;
import br.com.alpoo.jogo.dao.jogoDAO;
import br.com.alpoo.jogo.entity.Jogo;
import br.com.alpoo.jogo.service.JogoService;

@Service("jogoService")
public class JogoServiceImpl implements JogoService {

	@Autowired
	private jogoDAO dao;

	@Override
	@Transactional
	public Jogo salva(List<Integer> tabuleiro, Usuario usuario, Jogo jogo) {
		if(jogo == null) {
			jogo = new Jogo();
			jogo.setJogDataCriacao(new Date());
		}
		
		byte[] arr = new byte[tabuleiro.size() + 1];
		int index = 0;
		for(Integer r : tabuleiro) {
			arr[index] = r.byteValue();
			index++;
		}
		System.out.println(arr);
		jogo.setJogEstado(arr);
		jogo.setJogDataAtualizacao(new Date());
		jogo.setUsuario(usuario);
		
		return dao.salva(jogo);
	}

	@Override
	public Jogo getJogoByUsuario(Integer usrCodigo) {
		return dao.getJogoByUsuario(usrCodigo);
	}

	@Override
	public List<Integer> retornaListaJogo(byte[] estadoJogo) {
		List<Integer> lista = new ArrayList<Integer>();
		for(int i = 0; i < estadoJogo.length -1 ; i++) {
			int j = estadoJogo[i];
			lista.add(j);
		}
		return lista;
	}

}
