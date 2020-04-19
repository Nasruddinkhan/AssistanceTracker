/**
 * nasru
 * Test.java
 * Apr 5, 2020
 */
package com.mypractice.assistancetracker.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mypractice.assistancetracker.model.Authorities;
import com.mypractice.assistancetracker.model.User;

/**
 * @author nasru
 *
 */
public class Test {
	void print(Object obj) {
		System.out.println("obj ");
	}

	void print(String obj) {
		System.out.println("string obj ");
	}

	public static void main(String[] args) {
		User user = new User();
		user.setEnabled(true);
		user.setPassword( new BCryptPasswordEncoder().encode("Nasru@1992"));
		Authorities auth = new Authorities(); 
		auth.setAuthority("ROLE_MEMBER");
		
	}
}
