/**
 * nasru
 * CountryDTO.java
 * Mar 28, 2020
 */
package com.mypractice.assistancetracker.dto;

/**
 * @author nasru
 *
 */
public class CountryDTO {
	private String countryCode;
	private String countryName;
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
	 */
	public CountryDTO(String countryCode, String countryName) {
		super();
		this.countryCode = countryCode;
		this.countryName = countryName;
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
