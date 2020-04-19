/**
 * nasru
 * PinCodeDaoImpl.java
 * Apr 10, 2020
 */
package com.mypractice.assistancetracker.daoimpl;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mypractice.assistancetracker.dao.PinCodeDao;
import com.mypractice.assistancetracker.model.City;
import com.mypractice.assistancetracker.model.PinCode;

import static com.mypractice.assistancetracker.util.CommonUtils.CITY;
import static com.mypractice.assistancetracker.util.QueryConstant.FIND_ALL_PINCODE;
/**
 * @author nasru
 *
 */
@Repository("pinCodeDao")
public class PinCodeDaoImpl implements PinCodeDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public void savePincode(PinCode pinCode) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(pinCode);
	}
	@Override
	public List<PinCode> findPinCode() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery(FIND_ALL_PINCODE, PinCode.class).list();
	}
	@Override
	public PinCode findPinCode(String pinCode) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().load(PinCode.class, pinCode);
	}
	@Override
	public void deletePinCode(PinCode findPinCode) {
		// TODO Auto-generated method stub
		 sessionFactory.getCurrentSession().delete(findPinCode);
	}
	@Override
	public String getPincode(City city) throws  Exception {
		// TODO Auto-generated method stub
		CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
		CriteriaQuery<String> query = builder.createQuery(String.class);
		Root<PinCode> root = query.from(PinCode.class);
		query.select(root.get("pinCode")).where(builder.equal(root.get(CITY), city));
		return sessionFactory.getCurrentSession().createQuery(query).getSingleResult();
	}

}
