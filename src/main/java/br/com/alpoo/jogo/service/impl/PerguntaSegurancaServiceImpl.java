package br.com.alpoo.jogo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alpoo.jogo.dao.PerguntaSergurancaDAO;
import br.com.alpoo.jogo.entity.PerguntaSeguranca;
import br.com.alpoo.jogo.service.PerguntaSegurancaService;

@Service("perguntaSegurancaService")
public class PerguntaSegurancaServiceImpl implements PerguntaSegurancaService {

	@Autowired
	private PerguntaSergurancaDAO dao;
	
	@Override
	public List<PerguntaSeguranca> getAll() {
		return dao.getAll();
	}

}
