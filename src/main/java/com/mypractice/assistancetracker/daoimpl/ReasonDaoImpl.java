/**
 * nasru
 * ReasonDaoImpl.java
 * Apr 16, 2020
 */
package com.mypractice.assistancetracker.daoimpl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mypractice.assistancetracker.dao.ReasonDao;
import com.mypractice.assistancetracker.model.Reason;

/**
 * @author nasru
 *
 */
@Repository("reasonDao")
public class ReasonDaoImpl implements ReasonDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveReason(Reason reason) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(reason);
	}

	@Override
	public List<Reason> getReasons() {
		// TODO Auto-generated method stub
		CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<Reason> criteriaQuery = builder.createQuery(Reason.class);
		Root<Reason> root = criteriaQuery.from(Reason.class);
		criteriaQuery.select(root);
		return sessionFactory.getCurrentSession().createQuery(criteriaQuery).getResultList();
	}

	@Override
	public Reason editReason(Integer reasonId) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().load(Reason.class, reasonId);
	}

	@Override
	public void deleteReason(Reason editReason) {
		// TODO Auto-generated method stub
		 sessionFactory.getCurrentSession().delete(editReason);
	}

}
