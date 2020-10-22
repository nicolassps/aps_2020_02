package br.com.alpoo.jogo.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.alpoo.jogo.dao.PerguntaSergurancaDAO;
import br.com.alpoo.jogo.entity.PerguntaSeguranca;
import br.com.alpoo.util.dao.impl.GenericDAOImpl;

@Repository
public class PerguntaSegurancaDAOImpl extends GenericDAOImpl<PerguntaSeguranca, Serializable> implements PerguntaSergurancaDAO{

	@Override
	public List<PerguntaSeguranca> getAll() {
		return getAll(PerguntaSeguranca.class);
	}

	
}
