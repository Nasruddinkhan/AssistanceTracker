/**
 * nasru
 * StateDto.java
 * Apr 4, 2020
 */
package com.mypractice.assistancetracker.dto;

import static com.mypractice.assistancetracker.util.CommonUtils.FIELD_INVALID;
import static com.mypractice.assistancetracker.util.CommonUtils.INVALID_FIELD_SIZE;
import static com.mypractice.assistancetracker.util.CommonUtils.LEN_2;
import static com.mypractice.assistancetracker.util.CommonUtils.LEN_3;
import static com.mypractice.assistancetracker.util.CommonUtils.LEN_50;
import static com.mypractice.assistancetracker.util.CommonUtils.ONLY_ALPHABET_ALLOW;
import static com.mypractice.assistancetracker.util.CommonUtils.ONLY_APHA_CHAR_PATTERN;
import static com.mypractice.assistancetracker.util.CommonUtils.ONLY_CHAR_ALLOW;
import static com.mypractice.assistancetracker.util.CommonUtils.ONLY_CHAR_PATTERN;
import static com.mypractice.assistancetracker.util.CommonUtils.START_DOLLAR;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;
/**
 * @author nasru
 *
 */
public class StateDto {
	@Size(max = LEN_3, min =LEN_3, message = INVALID_FIELD_SIZE)
	@NotBlank(message = FIELD_INVALID)
	@Pattern(regexp= ONLY_APHA_CHAR_PATTERN + START_DOLLAR  ,message=ONLY_ALPHABET_ALLOW )  
	private String stateCode;
	@Pattern(regexp= ONLY_CHAR_PATTERN + START_DOLLAR ,message=ONLY_CHAR_ALLOW )  
	@Size(max = LEN_50, min =LEN_3, message = INVALID_FIELD_SIZE)
	@NotBlank(message = FIELD_INVALID)
	private String stateName;
	@Size(max = LEN_2, min =LEN_2, message = INVALID_FIELD_SIZE)
	@NotBlank(message = FIELD_INVALID)
	private String alpha2Code;
	@NotBlank(message = FIELD_INVALID)
	private String country;
	public  transient String isNew;
	public transient String countryName;
	
	/**
	 * @return the countryName
	 */
	public String getCountryName() {
		return countryName;
	}


	/**
	 * @param countryName the countryName to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}


	/**
	 * @return the isNew
	 */
	public String getIsNew() {
		return isNew;
	}


	/**
	 * @param isNew the isNew to set
	 */
	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}


	/**
	 * 
	 */
	public StateDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the stateName
	 */
	public String getStateName() {
		return stateName;
	}


	/**
	 * @return the alpha2Code
	 */
	public String getAlpha2Code() {
		return alpha2Code;
	}



	/**
	 * @param stateName the stateName to set
	 */
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}


	/**
	 * @param alpha2Code the alpha2Code to set
	 */
	public void setAlpha2Code(String alpha2Code) {
		this.alpha2Code = alpha2Code;
	}


	public String getStateCode() {
		return stateCode;
	}

	/**
	 * @param stateCode the stateCode to set
	 */
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}


	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}


	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

}
