/**
 * nasru
 * CityDTO.java
 * Apr 6, 2020
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
public class CityDTO {
 
	@NotBlank(message = FIELD_INVALID)
	@Size(max = LEN_3, min =LEN_3, message = INVALID_FIELD_SIZE)
	@Pattern(regexp= ONLY_APHA_CHAR_PATTERN + START_DOLLAR  ,message=ONLY_ALPHABET_ALLOW )
	private String cityCode;
	@NotBlank(message = FIELD_INVALID)
	@Pattern(regexp= ONLY_CHAR_PATTERN + START_DOLLAR ,message=ONLY_CHAR_ALLOW )  
	@Size(max = LEN_50, min =LEN_3, message = INVALID_FIELD_SIZE)
	private String cityName;
	@NotBlank(message = FIELD_INVALID)
	@Size(max = LEN_2, min =LEN_2, message = INVALID_FIELD_SIZE)
	private String cityAlphaCOde;
	@NotBlank(message = FIELD_INVALID)
	private String state;
	public  transient String isNew;
	public transient String stateName;
	
	
	/**
	 * @return the isNew
	 */
	public String getIsNew() {
		return isNew;
	}
	/**
	 * @return the stateName
	 */
	public String getStateName() {
		return stateName;
	}
	/**
	 * @param isNew the isNew to set
	 */
	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}
	/**
	 * @param stateName the stateName to set
	 */
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	/**
	 * 
	 */
	public CityDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param cityCode
	 * @param cityName
	 * @param cityAlphaCOde
	 * @param country
	 * @param state
	 */
	public CityDTO(String cityCode, String cityName, String cityAlphaCOde, String country, String state) {
		super();
		this.cityCode = cityCode;
		this.cityName = cityName;
		this.cityAlphaCOde = cityAlphaCOde;
		this.state = state;
	}
	/**
	 * @return the cityCode
	 */
	public String getCityCode() {
		return cityCode;
	}
	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}
	/**
	 * @return the cityAlphaCOde
	 */
	public String getCityAlphaCOde() {
		return cityAlphaCOde;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param cityCode the cityCode to set
	 */
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	/**
	 * @param cityAlphaCOde the cityAlphaCOde to set
	 */
	public void setCityAlphaCOde(String cityAlphaCOde) {
		this.cityAlphaCOde = cityAlphaCOde;
	}
	
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "CityDTO [cityCode=" + cityCode + ", cityName=" + cityName + ", cityAlphaCOde=" + cityAlphaCOde
				+ ", state=" + state + "]";
	}
	
	
}
