/**
 * nasru
 * StateService.java
 * Apr 4, 2020
 */
package com.mypractice.assistancetracker.service;

import java.util.List;

import com.mypractice.assistancetracker.dto.CommonDropDown;
import com.mypractice.assistancetracker.dto.StateDto;

/**
 * @author nasru
 *
 */
public interface StateService {
	List<CommonDropDown> getCountries();

	/**
	 * @param stateDto
	 * @throws Exception 
	 */
	void addSate(StateDto stateDto) throws Exception;

	/**
	 * @return
	 */
	List<StateDto> getStates();

	/**
	 * @param stateCode
	 * @return
	 */
	StateDto findState(String stateCode);
}
