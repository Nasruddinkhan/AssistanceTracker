/**
 * nasru
 * MemberDaoImpl.java
 * Apr 20, 2020
 */
package com.mypractice.assistancetracker.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mypractice.assistancetracker.dao.MemberDao;
import com.mypractice.assistancetracker.model.User;

/**
 * @author nasru
 *
 */
@Repository("memberDao")
public class MemberDaoImpl implements MemberDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public void saveMember(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

}
