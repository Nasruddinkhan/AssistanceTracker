/**
 * nasru
 * QueryConstant.java
 * Mar 28, 2020
 */
package com.mypractice.assistancetracker.util;

/**
 * @author nasru
 *
 */
public interface QueryConstant {
	public static final String MST_COMMON_DROPDOWN = "from MstCode where codeType = :";
	public static final String FIND_ALL_COUNTRY = "from Country";
	public static final String DELETE_COUNTRY_REC = "delete from Country where countryCode=:";
	public static final String FIND_ALL_STATE = "from State";
	public static final String DELETE_STATE_REC = "delete from State where stateCode=:";
}
