/**
 * nasru
 * MemberDaoImpl.java
 * Apr 20, 2020
 */
package com.mypractice.assistancetracker.daoimpl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mypractice.assistancetracker.dao.MemberDao;
import com.mypractice.assistancetracker.model.User;
import com.mypractice.assistancetracker.util.CommonUtils;

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
	@Override
	public List<User> findAllMember(int startPos) {
		// TODO Auto-generated method stub
		CriteriaBuilder criteriaBuilder =  sessionFactory.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery =  criteriaBuilder.createQuery(User.class);
		Root<User> root= criteriaQuery.from(User.class);
		criteriaQuery.select(root);
		return sessionFactory.getCurrentSession().createQuery(criteriaQuery)
				.setFirstResult(startPos)
				.setMaxResults(CommonUtils.PAGE_SIZE)
				.getResultList();
	}
	@Override
	public Long getMemeberPageCount() {
		// TODO Auto-generated method stub
		CriteriaBuilder criteriaBuilder =  sessionFactory.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery =  criteriaBuilder.createQuery(Long.class);
		Root<User> root=  criteriaQuery.from(User.class);
		criteriaQuery.multiselect(criteriaBuilder.count(root.get("username")));
		return sessionFactory.getCurrentSession().createQuery(criteriaQuery).getSingleResult();
	}

}
