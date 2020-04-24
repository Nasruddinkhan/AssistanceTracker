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
import static com.mypractice.assistancetracker.util.CommonUtils.USER_NAME;
import static com.mypractice.assistancetracker.util.CommonUtils.EMAIL_ID_LC;
import static com.mypractice.assistancetracker.util.CommonUtils.FIRSTNAME_LC;
import static com.mypractice.assistancetracker.util.CommonUtils.LASTNAME_LC;
import static com.mypractice.assistancetracker.util.CommonUtils.CONTACT_NO1_LC;
import static com.mypractice.assistancetracker.util.CommonUtils.CONTACT_NO_LC;
import static com.mypractice.assistancetracker.util.CommonUtils.PAGE_SIZE;
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
		criteriaQuery.multiselect(root.get(USER_NAME), root.get(EMAIL_ID_LC), root.get(FIRSTNAME_LC) , root.get(LASTNAME_LC), root.get(CONTACT_NO1_LC), 
				root.get(CONTACT_NO_LC)).where(criteriaBuilder.equal(root.get("isActive"),  true));
		return sessionFactory.getCurrentSession().createQuery(criteriaQuery)
				.setFirstResult(startPos)
				.setMaxResults(PAGE_SIZE)
				.getResultList();
	}
	
	@Override
	public Long getMemeberPageCount() {
		// TODO Auto-generated method stub
		CriteriaBuilder criteriaBuilder =  sessionFactory.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery =  criteriaBuilder.createQuery(Long.class);
		Root<User> root=  criteriaQuery.from(User.class);
		criteriaQuery.multiselect(criteriaBuilder.count(root.get(USER_NAME)));
		return sessionFactory.getCurrentSession().createQuery(criteriaQuery).getSingleResult();
	}
	@Override
	public User editMember(String userName) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().load(User.class, userName);
	}
	@Override
	public void deleteMember(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(user);
	}

}
