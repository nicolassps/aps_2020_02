package br.com.alpoo.acesso.autenticacao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.alpoo.acesso.entity.Usuario;
import br.com.alpoo.acesso.service.UsuarioService;
import br.com.alpoo.jogo.entity.PerguntaSeguranca;
import br.com.alpoo.jogo.service.PerguntaSegurancaService;
@Component (value = "registroController")
@Scope("view")
public class RegistroController{

	private Usuario usuario;
	private List<PerguntaSeguranca> listaPerguntaSeguranca;
	private String repetirSenha;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private PerguntaSegurancaService perguntaSegurancaService;

	@PostConstruct
	public void inicializa() {
		repetirSenha = "";
		usuario = new Usuario();
		listaPerguntaSeguranca = perguntaSegurancaService.getAll();
	}

	public void salva() {
		try {
			if(repetirSenha == usuario.getUsrSenha()) {
				usuario = usuarioService.salva(usuario);
				FacesContext.getCurrentInstance().getExternalContext().redirect("login.jsf");
			}else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("IESGF", "As senhas não conferem"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("IESGF", "Erro ao criar Usuario"));
		}
			
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<PerguntaSeguranca> getListaPerguntaSeguranca() {
		return listaPerguntaSeguranca;
	}

	public void setListaPerguntaSeguranca(List<PerguntaSeguranca> listaPerguntaSeguranca) {
		this.listaPerguntaSeguranca = listaPerguntaSeguranca;
	}

	public String getRepetirSenha() {
		return repetirSenha;
	}

	public void setRepetirSenha(String repetirSenha) {
		this.repetirSenha = repetirSenha;
	}



}
