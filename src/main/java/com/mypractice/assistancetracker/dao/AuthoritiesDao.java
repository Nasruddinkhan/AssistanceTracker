/**
 * nasru
 * AuthoritiesDao.java
 * Apr 21, 2020
 */
package com.mypractice.assistancetracker.dao;

import com.mypractice.assistancetracker.model.Authorities;

/**
 * @author nasru
 *
 */
public interface AuthoritiesDao {

	/**
	 * @param string
	 * @return
	 */
	public Authorities findRole(String role) ;
}
