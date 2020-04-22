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
	public List<Object[]> findAllMember(int startPos) {
		// TODO Auto-generated method stub
		CriteriaBuilder criteriaBuilder =  sessionFactory.getCriteriaBuilder();
		CriteriaQuery<Object[]> criteriaQuery =  criteriaBuilder.createQuery(Object[].class);
		Root<User> root= criteriaQuery.from(User.class);
		criteriaQuery.multiselect(root.get("username"), root.get("emailId"), root.get("firstName") , root.get("lastName"), root.get("cantactNo1"), root.get("contactNo"));
		return sessionFactory.getCurrentSession().createQuery(criteriaQuery)
				.setFirstResult(startPos)
				.setMaxResults(CommonUtils.PAGE_SIZE)
				.getResultList();
	}
	/*memberDTO.setMemberId(obj.getUsername());
	memberDTO.setEmailId(obj.getEmailId());
	memberDTO.setFirstName(obj.getFirstName());
	memberDTO.setLastName(obj.getLastName());
	memberDTO.setContactNo(obj.getContactNo());
	memberDTO.setCantactNo1(obj.getCantactNo1());*/
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
