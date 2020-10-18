package br.com.alpoo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import br.com.alpoo.acesso.autenticacao.LoginController;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private LoginController login;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
	        .antMatchers("/javax.faces.resource/**", "/resources/**", "/index.jsp", "/login.jsf", "/erro/**")
	        .permitAll();
        
        http.authorizeRequests().antMatchers("/nav/**").authenticated();
        
        http.authenticationProvider(login);
        
        http.formLogin().loginPage("/login.jsf").loginProcessingUrl("/login").usernameParameter("username").passwordParameter("password").failureUrl("/login.jsf?error=true").defaultSuccessUrl("/nav/dashboard.jsf", true); 
        http.logout().logoutUrl("/logout").invalidateHttpSession(true).logoutSuccessUrl("/login.jsf");
        http.csrf().disable();
    }

}
