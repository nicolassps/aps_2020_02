package br.com.alpoo.acesso.autenticacao;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.context.PrimeFacesContext;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.alpoo.acesso.entity.Usuario;
import br.com.alpoo.acesso.service.UsuarioService;

@Component (value = "alteracaoSenhaController")
@Scope("view")
public class AlteracaoSenhaController {
	
	private Usuario usuario = new Usuario();
	private String confirmacaoSenha;

	@Autowired
	private UsuarioService usuarioService;
	
	public void buscaUsuario() {
		usuario = usuarioService.buscaByLogin(usuario.getUsrLogin());
		
		if(usuario == null) {
			usuario = new Usuario();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("IESGF", "Usuário não encontrado"));
		}
	}
	
	public void salvaSenhaNova() {
		Usuario usuarioAntigo = usuarioService.getById(usuario.getUsrCodigo());
		
		if(!usuario.getUsrRespostaSeguranca().equals(usuarioAntigo.getUsrRespostaSeguranca())) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("IESGF", "Resposta inválida"));
			return;
		} else if (!confirmacaoSenha.equals(usuario.getUsrSenha())) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("IESGF", "Senhas não conferem"));
			return;
		}
		
		usuarioAntigo.setUsrSenha(confirmacaoSenha);
		usuarioService.salva(usuarioAntigo);
		
		usuario = new Usuario();
	
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("IESGF", "Senha alterada com sucesso"));
		RequestContext.getCurrentInstance().update("dgResetSenha");
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getConfirmacaoSenha() {
		return confirmacaoSenha;
	}

	public void setConfirmacaoSenha(String confirmacaoSenha) {
		this.confirmacaoSenha = confirmacaoSenha;
	}	
	
}
