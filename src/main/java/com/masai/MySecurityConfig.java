package com.masai;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.ui.LoginPageGeneratingWebFilter;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		    .csrf().disable()
			.authorizeRequests()
//			.antMatchers(HttpMethod.GET,"/public/**").permitAll()
			.antMatchers("/public/**").hasRole("NORMAL")
			.antMatchers("/signin").permitAll()
			.anyRequest()
			.authenticated()
			.and()
//			.httpBasic();
			.formLogin()
		    .loginPage("/signin");
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("mahesh").password("abc").roles("NORMAL");
//		auth.inMemoryAuthentication().withUser("ramu").password("abcd").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("ramlal").password(this.passwordEncoder().encode("ramla")).roles("NORMAL");
		auth.inMemoryAuthentication().withUser("mahrsh").password(this.passwordEncoder().encode("mahesh")).roles("ADMIN");
		
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
		return new BCryptPasswordEncoder(10);
	}
	
	
	
	

}
