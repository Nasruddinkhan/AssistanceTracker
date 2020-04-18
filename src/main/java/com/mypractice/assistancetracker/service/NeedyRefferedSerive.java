/**
 * nasru
 * NeedyRefferedSerive.java
 * Apr 17, 2020
 */
package com.mypractice.assistancetracker.service;

import java.util.List;

import com.mypractice.assistancetracker.dto.CommonDropDown;
import com.mypractice.assistancetracker.dto.NeedyRefferedDto;

/**
 * @author nasru
 *
 */
public interface NeedyRefferedSerive {

	/**
	 * @return
	 */
	List<NeedyRefferedDto> findAllRefferer();

	/**
	 * @return
	 */
	List<CommonDropDown> findAllRelationShip();

	/**
	 * @param refferDto
	 */
	void saveNeedyRefferer(NeedyRefferedDto refferDto);

	/**
	 * @param reasonId
	 * @return
	 */
	NeedyRefferedDto editNeedyRefferer(Integer needyReferId);

	/**
	 * @param needyReferId
	 */
	void deleteNeedyRefferer(Integer needyReferId);

}
