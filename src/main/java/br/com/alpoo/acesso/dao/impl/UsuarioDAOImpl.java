package br.com.alpoo.acesso.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import br.com.alpoo.acesso.dao.UsuarioDAO;
import br.com.alpoo.acesso.entity.Usuario;
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

}
