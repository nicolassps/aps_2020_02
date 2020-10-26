package br.com.alpoo.acesso.dao;

import br.com.alpoo.acesso.entity.Usuario;

public interface UsuarioDAO {

	public Usuario salva(Usuario usuario);
	
	public Usuario getById(Integer usrCodigo);
	
	public Usuario getUsuarioByLoginAndPass(String login, String senha);
	
	public Usuario buscaByLogin(String login);
}
