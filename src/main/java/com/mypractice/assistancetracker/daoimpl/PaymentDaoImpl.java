/**
 * nasru
 * PaymentDaoImpl.java
 * Apr 11, 2020
 */
package com.mypractice.assistancetracker.daoimpl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mypractice.assistancetracker.dao.PaymentDao;
import com.mypractice.assistancetracker.model.PaymentMode;

/**
 * @author nasru
 *
 */
@Repository("paymentDao")
public class PaymentDaoImpl implements PaymentDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public PaymentMode exitsByPaymentModeName(String payementModeName) {
		// TODO Auto-generated method stub
		CriteriaBuilder criteriaBuilder = sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<PaymentMode> criteriaQuery = criteriaBuilder.createQuery(PaymentMode.class);
		Root<PaymentMode> root = criteriaQuery.from(PaymentMode.class);
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("paymentModeName"), payementModeName));
		return sessionFactory.getCurrentSession().createQuery(criteriaQuery).getSingleResult();
	}
	@Override
	public void savePaymentMode(PaymentMode mode) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(mode);
	}
	@Override
	public List<PaymentMode> findAllPayment() {
		// TODO Auto-generated method stub
		CriteriaBuilder criteriaBuilder = sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<PaymentMode> criteriaQuery = criteriaBuilder.createQuery(PaymentMode.class);
		Root<PaymentMode> root = criteriaQuery.from(PaymentMode.class);
		criteriaQuery.select(root);
		return sessionFactory.getCurrentSession().createQuery(criteriaQuery).getResultList();
	}
	@Override
	public PaymentMode editPaymentMode(String paymentModeId) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().load(PaymentMode.class, paymentModeId);
	}
	@Override
	public void deletePaymentMode(PaymentMode paymentMode) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(paymentMode);
	}

}
