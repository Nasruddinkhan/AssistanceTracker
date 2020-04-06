/**
 * nasru
 * StateDaoImpl.java
 * Apr 4, 2020
 */
package com.mypractice.assistancetracker.daoimpl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mypractice.assistancetracker.dao.StateDao;
import com.mypractice.assistancetracker.model.State;
import static com.mypractice.assistancetracker.util.CommonUtils.STATE_CODE;
import static com.mypractice.assistancetracker.util.QueryConstant.DELETE_STATE_REC;
import static com.mypractice.assistancetracker.util.QueryConstant.FIND_ALL_STATE;

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
}
