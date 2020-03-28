/**
 * nasru
 * Country.java
 * Mar 28, 2020
 */
package com.mypractice.assistancetracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import static com.mypractice.assistancetracker.util.CommonUtils.COUNTRY_MASTER;
import static com.mypractice.assistancetracker.util.CommonUtils.COUNTRY_CODE;
import static com.mypractice.assistancetracker.util.CommonUtils.COUNTRY_NAME;
import static com.mypractice.assistancetracker.util.CommonUtils.LEN_3;
import static com.mypractice.assistancetracker.util.CommonUtils.LEN_50;

/**
 * @author nasru
 *
 */
@Entity
@Table(name = COUNTRY_MASTER)
public class Country {
	@Id
	@Column(name = COUNTRY_CODE, length = LEN_3)
	private String countryCode;
	@Column(name = COUNTRY_NAME, length = LEN_50)
	private String countryName;

	/**
	 * 
	 */
	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param countryCode
	 * @param countryName
	 */
	public Country(String countryCode, String countryName) {
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
