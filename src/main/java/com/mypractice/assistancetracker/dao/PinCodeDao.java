/**
 * nasru
 * PinCodeDao.java
 * Apr 10, 2020
 */
package com.mypractice.assistancetracker.dao;

import java.util.List;

import com.mypractice.assistancetracker.model.PinCode;

/**
 * @author nasru
 *
 */
public interface PinCodeDao {

	/**
	 * @param pinCode
	 */
	void savePincode(PinCode pinCode);

	/**
	 * @return
	 */
	List<PinCode> findPinCode();

	/**
	 * @param pinCode
	 * @return
	 */
	PinCode findPinCode(String pinCode);

	/**
	 * @param findPinCode
	 */
	void deletePinCode(PinCode findPinCode);

}
