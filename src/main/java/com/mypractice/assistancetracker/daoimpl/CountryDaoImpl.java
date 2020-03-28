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

}
