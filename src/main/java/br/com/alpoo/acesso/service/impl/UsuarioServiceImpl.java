package br.com.alpoo.acesso.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.alpoo.acesso.dao.UsuarioDAO;
import br.com.alpoo.acesso.entity.Usuario;
import br.com.alpoo.acesso.service.UsuarioService;

@Repository("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDAO dao;
	
	@Override
	public Usuario salva(Usuario usuario) {
		return dao.salva(usuario);
	}

	@Override
	public Usuario getById(Integer usrCodigo) {
		return dao.getById(usrCodigo);
	}

}
