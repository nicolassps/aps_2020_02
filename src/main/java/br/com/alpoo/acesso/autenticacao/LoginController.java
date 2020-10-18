package br.com.alpoo.acesso.autenticacao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class LoginController implements AuthenticationProvider {
		 
	    @Override
	    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	 
	        String name = authentication.getName();
	        String password = authentication.getCredentials().toString();
	        
	        if (name.equals("IESGF") && password.equals("pass")) {
	            return new UsernamePasswordAuthenticationToken(name, password, new ArrayList<>());
	        } else {
	            return null;
	        }
	    }
	 
	    @Override
	    public boolean supports(Class<?> authentication) {
	        return authentication.equals(UsernamePasswordAuthenticationToken.class);
	    }
	    
}
