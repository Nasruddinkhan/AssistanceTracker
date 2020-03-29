/**
 * nasru
 * CountryDTO.java
 * Mar 28, 2020
 */
package com.mypractice.assistancetracker.dto;

import static com.mypractice.assistancetracker.util.CommonUtils.COUNTRY_CODE_INVALID;
import static com.mypractice.assistancetracker.util.CommonUtils.COUNTRY_NAME_INVALID;
import static com.mypractice.assistancetracker.util.CommonUtils.FIELD_INVALID;
import static com.mypractice.assistancetracker.util.CommonUtils.INVALID_FIELD_SIZE;
import static com.mypractice.assistancetracker.util.CommonUtils.LEN_2;
import static com.mypractice.assistancetracker.util.CommonUtils.LEN_3;
import static com.mypractice.assistancetracker.util.CommonUtils.LEN_50;
import static com.mypractice.assistancetracker.util.CommonUtils.ONLY_ALPHABET_ALLOW;
import static com.mypractice.assistancetracker.util.CommonUtils.ONLY_APHA_CHAR_PATTERN;
import static com.mypractice.assistancetracker.util.CommonUtils.ONLY_CHAR_ALLOW;
import static com.mypractice.assistancetracker.util.CommonUtils.ONLY_CHAR_PATTERN;
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
public class CountryDTO {
	@Pattern(regexp= ONLY_APHA_CHAR_PATTERN + START_DOLLAR  ,message=ONLY_ALPHABET_ALLOW )  
	@Size(max = LEN_3, min =LEN_3, message = INVALID_FIELD_SIZE)
	@NotBlank(message = COUNTRY_CODE_INVALID)
	private String countryCode;
	@Pattern(regexp= ONLY_CHAR_PATTERN + START_DOLLAR ,message=ONLY_CHAR_ALLOW )  
	@Size(max = LEN_50, min = LEN_3, message = INVALID_FIELD_SIZE)
	@NotBlank(message = COUNTRY_NAME_INVALID)
	private String countryName;
	@Pattern(regexp= ONLY_APHA_CHAR_PATTERN + START_DOLLAR  ,message=ONLY_ALPHABET_ALLOW )  
	@Size(max = LEN_2, min =LEN_2, message = INVALID_FIELD_SIZE)
	@NotBlank(message = FIELD_INVALID)
	private String alpha2Code;
	@Pattern(regexp= ONLY_DIGIT + START_DOLLAR ,message=ONLY_DIGIT_ALLOW )  
	@Size(max = LEN_3, min =LEN_3, message = INVALID_FIELD_SIZE)
	@NotBlank(message = FIELD_INVALID)
	private String numbericCode;
	public  transient String isNew;
	

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
	public CountryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param countryCode
	 * @param countryName
	 * @param alpha2Code
	 * @param numbericCode
	 */
	public CountryDTO(String countryCode, String countryName, String alpha2Code, String numbericCode) {
		super();
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.alpha2Code = alpha2Code;
		this.numbericCode = numbericCode;
	}

	/**
	 * @return the alpha2Code
	 */
	public String getAlpha2Code() {
		return alpha2Code;
	}

	/**
	 * @return the numbericCode
	 */
	public String getNumbericCode() {
		return numbericCode;
	}

	/**
	 * @param alpha2Code the alpha2Code to set
	 */
	public void setAlpha2Code(String alpha2Code) {
		this.alpha2Code = alpha2Code;
	}

	/**
	 * @param numbericCode the numbericCode to set
	 */
	public void setNumbericCode(String numbericCode) {
		this.numbericCode = numbericCode;
	}

	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @return the countryName
	 */
	public String getCountryName() {
		return countryName;
	}
	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	/**
	 * @param countryName the countryName to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
}
