/**
 * nasru
 * AuthoritiesDaoImpl.java
 * Apr 21, 2020
 */
package com.mypractice.assistancetracker.daoimpl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mypractice.assistancetracker.dao.AuthoritiesDao;
import com.mypractice.assistancetracker.model.Authorities;

/**
 * @author nasru
 *
 */
@Repository("authoritiesDao")
public class AuthoritiesDaoImpl implements AuthoritiesDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public Authorities findRole(String role) {
		// TODO Auto-generated method stub
		Authorities authorities = null;
		try {
			CriteriaBuilder criteriaBuilder = sessionFactory.getCriteriaBuilder();
			CriteriaQuery<Authorities> criteriaQuery = criteriaBuilder.createQuery(Authorities.class);
			Root<Authorities> root = criteriaQuery.from(Authorities.class);
			criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("authority"), role));
			authorities = sessionFactory.getCurrentSession().createQuery(criteriaQuery).getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return authorities;
	}

}
