package br.com.alpoo.acesso.controller;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "acessoMB")
@Scope("view")
public class AcessoMB implements Serializable{
	private static final long serialVersionUID = -7810464530178509923L;
	
	private String teste = "TESTE";

	public String getTeste() {
		return teste;
	}

	public void setTeste(String teste) {
		this.teste = teste;
	}
	
	
	
}
