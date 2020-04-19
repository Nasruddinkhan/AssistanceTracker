/**
 * nasru
 * CityDaoImpl.java
 * Apr 7, 2020
 */
package com.mypractice.assistancetracker.daoimpl;

import static com.mypractice.assistancetracker.util.CommonUtils.STATE;
import static com.mypractice.assistancetracker.util.QueryConstant.FIND_ALL_CITY;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mypractice.assistancetracker.dao.CityDao;
import com.mypractice.assistancetracker.model.City;
import com.mypractice.assistancetracker.model.State;

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
	@Override
	public List<City> getCities(State state) {
		// TODO Auto-generated method stub
		CriteriaBuilder criteriaBuilder = sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<City> criteriaQuery = criteriaBuilder.createQuery(City.class);
		Root<City> root = criteriaQuery.from(City.class);
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get(STATE), state));
		return sessionFactory.getCurrentSession().createQuery(criteriaQuery).getResultList();
	}

}
