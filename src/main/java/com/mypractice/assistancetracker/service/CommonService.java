/**
 * nasru
 * CommonService.java
 * Apr 19, 2020
 */
package com.mypractice.assistancetracker.service;

import java.util.List;

import com.mypractice.assistancetracker.dto.CommonDropDown;
import com.mypractice.assistancetracker.dto.MemberDTO;

/**
 * @author nasru
 *
 */
public interface CommonService {

	/**
	 * @param countryId
	 * @return
	 */
	List<CommonDropDown> getStates(String countryId);

	/**
	 * @param stateId
	 * @return
	 */
	List<CommonDropDown> getCities(String stateId);

	/**
	 * @param pincodeId
	 * @return
	 */
	String getPincode(String cityId);

	/**
	 * @param memberID
	 * @return
	 */
	MemberDTO getMember(String memberID);

}
