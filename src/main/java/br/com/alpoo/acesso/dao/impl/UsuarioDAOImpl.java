package br.com.alpoo.acesso.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.alpoo.acesso.dao.UsuarioDAO;
import br.com.alpoo.acesso.entity.Usuario;
import br.com.alpoo.jogo.entity.Jogo;
import br.com.alpoo.util.dao.impl.GenericDAOImpl;

@Repository
public class UsuarioDAOImpl extends GenericDAOImpl<Usuario, Serializable> implements UsuarioDAO {

	@Override
	public Usuario salva(Usuario usuario) {
		return save(usuario);
	}

	@Override
	public Usuario getById(Integer usrCodigo) {
		return getById(Usuario.class, usrCodigo);
	}

	@Override
	public Usuario getUsuarioByLoginAndPass(String login, String senha) {
		Query query = em.createQuery(" from Usuario u where u.usrLogin = :login and u.usrSenha = :senha ");
		query.setParameter("login", login);
		query.setParameter("senha", senha);
		
		List<Usuario> listaUsuario = query.getResultList();
		return listaUsuario.size() > 0 ? listaUsuario.get(0) : null;
	}

}
