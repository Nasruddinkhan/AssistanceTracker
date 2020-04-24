/**
 * nasru
 * StateDaoImpl.java
 * Apr 4, 2020
 */
package com.mypractice.assistancetracker.daoimpl;

import static com.mypractice.assistancetracker.util.CommonUtils.COUNTRY;
import static com.mypractice.assistancetracker.util.CommonUtils.STATE_CODE;
import static com.mypractice.assistancetracker.util.QueryConstant.DELETE_STATE_REC;
import static com.mypractice.assistancetracker.util.QueryConstant.FIND_ALL_STATE;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mypractice.assistancetracker.dao.StateDao;
import com.mypractice.assistancetracker.model.Country;
import com.mypractice.assistancetracker.model.State;

/**
 * @author nasru
 *
 */
@Repository("stateDao")
public class StateDaoImpl implements StateDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public void addSate(State state) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.clear();
		session.flush();
		session.saveOrUpdate(state);
	}
	@Override
	public List<State> getStates() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery(FIND_ALL_STATE, State.class).getResultList();
	}
	@Override
	public State findState(String stateCode) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().load(State.class, stateCode);
	}
	@Override
	public void deleteState(String stateCode) {
		// TODO Auto-generated method stub
		 sessionFactory.getCurrentSession().createQuery(DELETE_STATE_REC.concat(STATE_CODE))
				.setParameter(STATE_CODE, stateCode).executeUpdate();
	}
	@Override
	public List<State> getStates(Country country) {
		// TODO Auto-generated method stub
		CriteriaBuilder criteriaBuilder = sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<State> criteriaQuery = criteriaBuilder.createQuery(State.class);
		Root<State> root = criteriaQuery.from(State.class);
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get(COUNTRY), country));
		return sessionFactory.getCurrentSession().createQuery(criteriaQuery).getResultList();
	}
}
