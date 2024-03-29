package com.mypractice.assistancetracker.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	@Qualifier("persistentTokenRepository")
	private PersistentTokenRepository persistentTokenRepository;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	};
	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	*/
	 	@Bean
	    @Override
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }
	    
	    @Override
	    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	    }
	    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().sameOrigin();
		http.sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
		http.authorizeRequests().anyRequest().authenticated()
		//.hasAnyRole("ROLE_ADMIN", "ROLE_MEMBER")
		.and()
		.authorizeRequests().antMatchers("/login.do**").permitAll()
		.and()
		.formLogin().loginPage("/login.do").loginProcessingUrl("/login.do")
		.defaultSuccessUrl("/dasboard.do", true)
		.failureUrl("/login.do?error=true")
		.permitAll()
		.and()
		.logout().logoutSuccessUrl("/login.do").permitAll()
		.and()
		.rememberMe().rememberMeParameter("remember-me")
		.tokenRepository(persistentTokenRepository).userDetailsService(userDetailsService)
		.and()
		.csrf().disable();
	}
	@Override
	public void configure(WebSecurity web) throws Exception {
		web
		.ignoring()
		.antMatchers("/resources/**");
	}
}
