/**
 * nasru
 * MemberDao.java
 * Apr 20, 2020
 */
package com.mypractice.assistancetracker.dao;

import java.util.List;

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

	/**
	 * @param startPos
	 * @return
	 */
	List<Object[]> findAllMember(int startPos);

	/**
	 * @return
	 */
	Long getMemeberPageCount();

}
