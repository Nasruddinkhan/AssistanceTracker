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
	 * @return
	 */
	Long getMemeberPageCount(User user);

	/**
	 * @param userName
	 * @return
	 */
	User editMember(String userName);

	/**
	 * @param user
	 */
	void deleteMember(User user);

	/**
	 * @param startPos
	 * @param logUser
	 * @return
	 */
	List<Object[]> findAllMember(int startPos, User logUser);

}
