package br.com.alpoo.acesso.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

import javax.transaction.Transactional;
import javax.xml.bind.DatatypeConverter;

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
	@Transactional
	public Usuario salva(Usuario usuario) {
		String sha1 = null;
		try {
			MessageDigest msdDigest = MessageDigest.getInstance("SHA-1");
			msdDigest.update(usuario.getUsrSenha().getBytes("UTF-8"), 0, usuario.getUsrSenha().length());
			sha1 = DatatypeConverter.printHexBinary(msdDigest.digest());
			usuario.setUsrSenha(sha1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dao.salva(usuario);
	}

	@Override
	public Usuario getById(Integer usrCodigo) {
		return dao.getById(usrCodigo);
	}

	@Override
	public Usuario getUsuarioByLoginAndPass(String login, String senha) {
		String sha1 = null;
		try {
			MessageDigest msdDigest = MessageDigest.getInstance("SHA-1");
			msdDigest.update(senha.getBytes("UTF-8"), 0, senha.length());
			sha1 = DatatypeConverter.printHexBinary(msdDigest.digest());
			return dao.getUsuarioByLoginAndPass(login, sha1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
		
	}

	@Override
	public Usuario buscaByLogin(String login) {
		Usuario usr = dao.buscaByLogin(login);
		
		if(usr != null) {
			usr.setUsrSenha(null);
			usr.setUsrRespostaSeguranca(null);
		}
		
		return usr;
	}

}
