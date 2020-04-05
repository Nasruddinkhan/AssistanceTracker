/**
 * nasru
 * CountryDaoImpl.java
 * Mar 28, 2020
 */
package com.mypractice.assistancetracker.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mypractice.assistancetracker.dao.CountryDao;
import com.mypractice.assistancetracker.model.Country;
import static com.mypractice.assistancetracker.util.QueryConstant.FIND_ALL_COUNTRY;
import static com.mypractice.assistancetracker.util.CommonUtils.COUNTRYCODE;
import static com.mypractice.assistancetracker.util.QueryConstant.DELETE_COUNTRY_REC;
/**
 * @author nasru
 *
 */
@Repository("countryDao")
public class CountryDaoImpl implements CountryDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Country> findAllCountry() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery(FIND_ALL_COUNTRY, Country.class).getResultList();
	}
	@Override
	public void addCountry(Country country) {
		// TODO Auto-generated method stub
		 sessionFactory.getCurrentSession().saveOrUpdate(country);
	}
	@Override
	public void deleteCountry(Country country) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(country);
	}
	@Override
	public Country findByCountry(String countryCode) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Country.class,countryCode);
	}
	@Override
	public Integer deleteCountryByCode(String countryCode) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery(DELETE_COUNTRY_REC.concat(COUNTRYCODE))
				.setParameter(COUNTRYCODE, countryCode).executeUpdate();
	}
}
