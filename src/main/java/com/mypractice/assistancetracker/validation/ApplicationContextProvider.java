/**
 * nasru
 * ApplicationContextProvider.java
 * Apr 11, 2020
 */
package com.mypractice.assistancetracker.validation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author nasru
 *
 */
public class ApplicationContextProvider implements ApplicationContextAware {
	private static ApplicationContext context;

	public static ApplicationContext getApplicationContext() {
		return context;
	}

	@Override
	public void setApplicationContext(ApplicationContext ctx) {
		context = ctx;
	}
}
