package br.com.alpoo.acesso.service;

import br.com.alpoo.acesso.entity.Usuario;

public interface UsuarioService {

	public Usuario salva(Usuario usuario);
	
	public Usuario getById(Integer usrCodigo);
	
	public Usuario getUsuarioByLoginAndPass(String login, String senha);

}
