/**
 * nasru
 * CountryDao.java
 * Mar 28, 2020
 */
package com.mypractice.assistancetracker.dao;

import java.util.List;

import com.mypractice.assistancetracker.model.Country;

/**
 * @author nasru
 *
 */
public interface CountryDao {
	public List<Country> findAllCountry();
}
