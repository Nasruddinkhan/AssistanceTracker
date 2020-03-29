/**
 * nasru
 * CountryService.java
 * Mar 28, 2020
 */
package com.mypractice.assistancetracker.service;

import java.util.List;

import com.mypractice.assistancetracker.dto.CountryDTO;

/**
 * @author nasru
 *
 */
public interface CountryService {
	List<CountryDTO> findAllCountry();
	void addCountry(CountryDTO countryDTO) throws Exception;
	Integer deleteCountry(String countryCode);
	/**
	 * @param countryCode
	 * @return
	 * @throws Exception 
	 */
	CountryDTO findCountry(String countryCode) throws Exception;
}
