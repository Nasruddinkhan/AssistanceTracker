/*package com.mypractice.assistancetracker.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

//@EnableWebSecurity
public class WebSecurityConfig2bkp extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private AuthenticationSuccessHandler myAuthenticationSuccessHandler;
	@Autowired
	@Qualifier("persistentTokenRepository")
	private PersistentTokenRepository persistentTokenRepository;

    @Autowired
    private LogoutSuccessHandler myLogoutSuccessHandler;

	@Autowired
	private AuthenticationFailureHandler authenticationFailureHandler;
	@Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	};
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.anyRequest()
				.hasAnyRole("ADMIN", "USER")
				.and()
				.authorizeRequests()
				.antMatchers("/login.do**")
				.permitAll()
				.and()
				.formLogin()
				.loginPage("/login.do")
				.loginProcessingUrl("/login.do")
				.defaultSuccessUrl("/dasboard.do", true)
				.failureUrl("/login.do?error=true")
				.successHandler(myAuthenticationSuccessHandler)
				.failureHandler(authenticationFailureHandler)
				.permitAll()
				.and()
				 .sessionManagement()
	                .invalidSessionUrl("/invalidSession.html")
	                .maximumSessions(1).sessionRegistry(sessionRegistry()).and()
	                .sessionFixation().none()
	               .and()
				.logout()
				.logoutSuccessHandler(myLogoutSuccessHandler)
                .invalidateHttpSession(false)
                .logoutSuccessUrl("/logout.html?logSucc=true")
                .deleteCookies("JSESSIONID")
                .permitAll()
				.logoutSuccessUrl("/login.do")
				.permitAll().and().rememberMe().rememberMeParameter("remember-me")
				.tokenRepository(persistentTokenRepository)
				.userDetailsService(userDetailsService)
				.and()
				.csrf()
				.disable();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}
	 @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }
}
*/