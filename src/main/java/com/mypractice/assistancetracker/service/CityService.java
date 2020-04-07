/**
 * nasru
 * CityService.java
 * Apr 6, 2020
 */
package com.mypractice.assistancetracker.service;

import java.util.List;

import com.mypractice.assistancetracker.dto.CityDTO;
import com.mypractice.assistancetracker.dto.CommonDropDown;

/**
 * @author nasru
 *
 */
public interface CityService {

	/**
	 * @return
	 */
	public List<CommonDropDown> getState() ;

	/**
	 * @param cityDto
	 */
	public void saveCity(CityDTO cityDto);

	/**
	 * @return
	 */
	public List<CityDTO> findAllCity();

	/**
	 * @param cityCode
	 * @return
	 */
	public CityDTO findCity(String cityCode);

	/**
	 * @param cityCode
	 */
	public void deleteCity(String cityCode);

}
