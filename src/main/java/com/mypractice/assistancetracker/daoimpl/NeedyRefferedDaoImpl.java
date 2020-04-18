/**
 * nasru
 * NeedyRefferedDaoImpl.java
 * Apr 18, 2020
 */
package com.mypractice.assistancetracker.daoimpl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mypractice.assistancetracker.dao.NeedyRefferedDao;
import com.mypractice.assistancetracker.model.NeedyReffered;

/**
 * @author nasru
 *
 */
@Repository("needyRefferedDao")
public class NeedyRefferedDaoImpl implements NeedyRefferedDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public void saveNeedyRefferer(NeedyReffered needyReffered) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(needyReffered);
	}
	@Override
	public List<NeedyReffered> findAllRefferer() {
		// TODO Auto-generated method stub
		CriteriaBuilder criteriaBuilder = sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<NeedyReffered> criteriaQuery = criteriaBuilder.createQuery(NeedyReffered.class);
		Root<NeedyReffered> root = criteriaQuery.from(NeedyReffered.class);
		criteriaQuery.select(root);
		return sessionFactory.getCurrentSession().createQuery(criteriaQuery).getResultList();
	}
	@Override
	public NeedyReffered editNeedyRefferer(Integer needyReferId) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().load(NeedyReffered.class, needyReferId);
	}
	@Override
	public void deleteNeedyRefferer(NeedyReffered editNeedyRefferer) {
		// TODO Auto-generated method stub
		 sessionFactory.getCurrentSession().delete(editNeedyRefferer);
	}
}
