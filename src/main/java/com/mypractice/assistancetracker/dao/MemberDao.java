/**
 * nasru
 * MemberDao.java
 * Apr 20, 2020
 */
package com.mypractice.assistancetracker.dao;

import com.mypractice.assistancetracker.model.User;

/**
 * @author nasru
 *
 */
public interface MemberDao {

	/**
	 * @param user
	 */
	void saveMember(User user);

}
