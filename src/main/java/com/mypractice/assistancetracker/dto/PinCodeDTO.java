/**
 * nasru
 * PinCodeDTO.java
 * Apr 9, 2020
 */
package com.mypractice.assistancetracker.dto;

import static com.mypractice.assistancetracker.util.CommonUtils.FIELD_INVALID;
import static com.mypractice.assistancetracker.util.CommonUtils.INVALID_FIELD_SIZE;
import static com.mypractice.assistancetracker.util.CommonUtils.LEN_6;
import static com.mypractice.assistancetracker.util.CommonUtils.ONLY_DIGIT;
import static com.mypractice.assistancetracker.util.CommonUtils.ONLY_DIGIT_ALLOW;
import static com.mypractice.assistancetracker.util.CommonUtils.START_DOLLAR;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author nasru
 *
 */
public class PinCodeDTO {

	@Pattern(regexp = ONLY_DIGIT + START_DOLLAR, message = ONLY_DIGIT_ALLOW)
	@Size(max = LEN_6, min = LEN_6, message = INVALID_FIELD_SIZE)
	@NotBlank(message = FIELD_INVALID)
	private String pinCode;
	@NotBlank(message = FIELD_INVALID)
	private String cityName;
	public String isNew;
	public String cityDtls;
	
	/**
	 * @return the isNew
	 */
	public String getIsNew() {
		return isNew;
	}
	/**
	 * @return the cityDtls
	 */
	public String getCityDtls() {
		return cityDtls;
	}
	/**
	 * @param isNew the isNew to set
	 */
	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}
	/**
	 * @param cityDtls the cityDtls to set
	 */
	public void setCityDtls(String cityDtls) {
		this.cityDtls = cityDtls;
	}
	/**
	 * @return the pinCode
	 */
	public String getPinCode() {
		return pinCode;
	}
	/**
	 * @return the city
	 */
	public String getCityName() {
		return cityName;
	}
	/**
	 * @param pinCode the pinCode to set
	 */
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	/**
	 * @param city the city to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	/**
	 * 
	 */
	public PinCodeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @param pinCode
	 * @param cityName
	 * @param isNew
	 * @param cityDtls
	 */
	public PinCodeDTO(String pinCode, String cityName, String isNew, String cityDtls) {
		super();
		this.pinCode = pinCode;
		this.cityName = cityName;
		this.isNew = isNew;
		this.cityDtls = cityDtls;
	}
	@Override
	public String toString() {
		return "PinCodeDTO [pinCode=" + pinCode + ", cityName=" + cityName + "]";
	}
	
	
}
