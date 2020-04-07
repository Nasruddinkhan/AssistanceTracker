/**
 * nasru
 * CityDaoImpl.java
 * Apr 7, 2020
 */
package com.mypractice.assistancetracker.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import static com.mypractice.assistancetracker.util.QueryConstant.FIND_ALL_CITY;
import com.mypractice.assistancetracker.dao.CityDao;
import com.mypractice.assistancetracker.model.City;

/**
 * @author nasru
 *
 */
@Repository("cityDao")
public class CityDaoImpl implements CityDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public void saveCity(City city) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(city);
	}
	@Override
	public List<City> findAllCity() {
		// TODO Auto-generated method stub
		
		return sessionFactory.getCurrentSession().createQuery(FIND_ALL_CITY,City.class).getResultList();
	}
	@Override
	public City findCity(String cityCode) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().load(City.class, cityCode);
	}
	@Override
	public void deleteCity(City city) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(city);
	}

}
