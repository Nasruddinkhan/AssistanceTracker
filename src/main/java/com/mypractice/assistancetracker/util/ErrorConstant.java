/**
 * nasru
 * ErrorConstant.java
 * Mar 28, 2020
 */
package com.mypractice.assistancetracker.util;

import java.util.ResourceBundle;

/**
 * @author nasru
 *
 */
public interface ErrorConstant {
	static final String ERR_BUNDLE_NAME="common";
	static final ResourceBundle ERR_BUNDLE=ResourceBundle.getBundle(ERR_BUNDLE_NAME);
	public static final String HTTP_STATUS_404 = getErrorProperties("HTTP_STATUS_404");
	public static final  String SUCCESS = getErrorProperties("SUCCESS");
	public static final String RECORD_SUCCESS = getErrorProperties("RECORD_SUCCESS");
	public static final String DELETE_SUCCESS = getErrorProperties("DELETE_SUCCESS");
	public static final String UPDATE_SUCCESS = getErrorProperties("UPDATE_SUCCESS");

	
	public static String getErrorProperties(String propertyKey) {
		return ERR_BUNDLE.getString(propertyKey);
	}
}
