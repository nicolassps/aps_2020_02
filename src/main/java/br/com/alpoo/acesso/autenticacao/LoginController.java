package br.com.alpoo.acesso.autenticacao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import br.com.alpoo.acesso.entity.Usuario;
import br.com.alpoo.acesso.service.UsuarioService;
import br.com.alpoo.jogo.controller.SessaoController;

@Component(value = "loginController")
public class LoginController implements AuthenticationProvider {

	private Boolean esqueciSenha = Boolean.FALSE;
	
	@Autowired
	UsuarioService usuarioService;

	@Autowired
	SessaoController sessaoController;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		

		String name = authentication.getName();
		String password = authentication.getCredentials().toString();
		String esqueciSenha = authentication.getName();
		Usuario u =null;

		if ((u = usuarioService.getUsuarioByLoginAndPass(name, password)) != null) {
			sessaoController.setUsuarioLogado(u);
			return new UsernamePasswordAuthenticationToken(name, password, new ArrayList<>());
		} else {
			return null;
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
	public Boolean esqueciMinhaSenha() {
		return esqueciSenha;
	}

	public Boolean getEsqueciSenha() {
		return esqueciSenha;
	}

	public void setEsqueciSenha(Boolean esqueciSenha) {
		this.esqueciSenha = esqueciSenha;
	}

	
}
