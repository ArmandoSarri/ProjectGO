package com.ProjectGO.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ProjectGO.servicioImpl.ServicioUsuarioImpl;

@Configuration
@EnableWebSecurity
public class MiSeguridad extends WebSecurityConfigurerAdapter{

	@Autowired
	private ServicioUsuarioImpl sui;
	
	@Bean
	BCryptPasswordEncoder encriptador(){
		
		return new BCryptPasswordEncoder();
	}
	
	public String encripta(String password) {
		
		return encriptador().encode(password);
	}

	// Autorización
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/", "/CSS/**", "/Imagenes/**", "/JS/**", "/login", "/registro", "/logout", "/index", "/submit").permitAll()
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/login").defaultSuccessUrl("/")
		.and().logout().logoutSuccessUrl("/index");
		
		//si no pones esto al hacer submit de un form da error forbidden
		http.csrf().disable();
	}
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {		
        auth.userDetailsService(sui).passwordEncoder(encriptador());
    }
}
