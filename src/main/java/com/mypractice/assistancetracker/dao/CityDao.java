/**
 * nasru
 * CityDao.java
 * Apr 7, 2020
 */
package com.mypractice.assistancetracker.dao;

import java.util.List;

import com.mypractice.assistancetracker.model.City;
import com.mypractice.assistancetracker.model.State;

/**
 * @author nasru
 *
 */
public interface CityDao {

	/**
	 * @param city
	 */
	void saveCity(City city);

	/**
	 * @return
	 */
	List<City> findAllCity();

	/**
	 * @param cityCode
	 * @return
	 */
	City findCity(String cityCode);

	/**
	 * @param findCity
	 */
	void deleteCity(City city);

	/**
	 * @param state
	 * @return
	 */
	List<City> getCities(State state);

	
}
