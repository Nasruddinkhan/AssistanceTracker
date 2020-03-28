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
}
