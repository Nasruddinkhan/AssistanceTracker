/**
 * nasru
 * CustomAuthenticationFailureHandler.java
 * Mar 30, 2020
 */
package com.mypractice.assistancetracker.config;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
/**
 * @author nasru
 *
 */
@Component("authenticationFailureHandler")
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler{
	
}
