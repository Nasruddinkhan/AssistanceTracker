/**
 * nasru
 * PinCodeService.java
 * Apr 9, 2020
 */
package com.mypractice.assistancetracker.service;

import java.util.List;

import com.mypractice.assistancetracker.dto.CommonDropDown;
import com.mypractice.assistancetracker.dto.PinCodeDTO;

/**
 * @author nasru
 *
 */

public interface PinCodeService {

	public List<CommonDropDown> getCity() ;
	
	public List<PinCodeDTO> findPinCode();

	/**
	 * @param pinCodeDTO
	 */
	public void savePincode(PinCodeDTO pinCodeDTO);

	/**
	 * @param pinCode
	 * @return
	 */
	public PinCodeDTO findPinCode(String pinCode);

	/**
	 * @param pinCode
	 */
	public void deletePinCode(String pinCode);

	/**
	 * @param cityId
	 * @return
	 */
	public String getPincode(String cityId);
}
