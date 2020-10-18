package br.com.alpoo.config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Redirect {
	
	@GetMapping("/")
	public void index(HttpServletResponse res) throws IOException {
		res.sendRedirect("/login.jsf");
	}
	
	@Controller
	public class ErroRedirect implements ErrorController  {
		int erro;
 
		@GetMapping("/error")
	    public void handleError(HttpServletRequest req, HttpServletResponse res) throws IOException {
			erro = res.getStatus();
			res.sendRedirect("/erro/" + erro + ".jsf");
	    }
	 
	    @Override
	    public String getErrorPath() {
	        return "/erro/" + erro + ".jsf";
	    }
	}
}
