package org.GestionBiblio.Config;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity

//@EnableGlobalMethodSecurity(securedEnabled = true, proxyTargetClass = true) 
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Autowired
	private UserDetailsService customUserDetailsService;
	
	@Autowired
	DataSource dataSource;
	
	/*@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}*/
	
	
	@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
	return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
	
	
	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
	auth
	   .userDetailsService(customUserDetailsService)
	   .passwordEncoder(passwordEncoder());
	}
	
	
	
	@Override
	public void configure(final WebSecurity web) throws Exception
	{
		web.ignoring()
		.antMatchers("/CSS/**")
		.antMatchers("/fonts/**")
		.antMatchers("/scss/**")
		.antMatchers("/images/**")
		.antMatchers("/JS/**");
		
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
	
		http
		 
		 .formLogin()
		 .loginPage("/login")
		 .defaultSuccessUrl("/Index")
		 .failureUrl("/login?error=true")
		 .permitAll()
		 .and()
		 .logout()
		 .logoutSuccessUrl("/login");
		
		http.authorizeRequests();
		
		
		
		  
		
		
		 
	     
		
		
		
		
	}
	
	PersistentTokenRepository persistentTokenRepository(){
	     JdbcTokenRepositoryImpl tokenRepositoryImpl = new JdbcTokenRepositoryImpl();
	     tokenRepositoryImpl.setDataSource(dataSource);
	     return tokenRepositoryImpl;
	    }

}
