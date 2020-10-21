package br.com.alpoo.jogo.dao.impl;

import java.io.Serializable;

import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import br.com.alpoo.jogo.dao.jogoDAO;
import br.com.alpoo.jogo.entity.Jogo;
import br.com.alpoo.util.dao.impl.GenericDAOImpl;

@Repository
public class JogoDAOImpl extends GenericDAOImpl<Jogo, Serializable> implements jogoDAO {

	@Override
	public Jogo salva(Jogo jogo) {
		return save(jogo);
	}

	@Override
	public Jogo getJogoByUsuario(Integer usrCodigo) {
		String hql = "from jogo.usuario.usrCodigo = :usrCodigo";
		Query query = em.createQuery(hql);
		
		query.setParameter("usrCodigo", usrCodigo);
		return (Jogo) query.getSingleResult();
	}

}
