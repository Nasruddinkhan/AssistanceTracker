/**
 * nasru
 * Country.java
 * Mar 28, 2020
 */
package com.mypractice.assistancetracker.model;
import static com.mypractice.assistancetracker.util.CommonUtils.ALPHA_2_CODE;
import static com.mypractice.assistancetracker.util.CommonUtils.COUNTRY;
import static com.mypractice.assistancetracker.util.CommonUtils.COUNTRY_CODE;
import static com.mypractice.assistancetracker.util.CommonUtils.COUNTRY_MASTER;
import static com.mypractice.assistancetracker.util.CommonUtils.COUNTRY_NAME;
import static com.mypractice.assistancetracker.util.CommonUtils.LEN_2;
import static com.mypractice.assistancetracker.util.CommonUtils.LEN_3;
import static com.mypractice.assistancetracker.util.CommonUtils.LEN_50;
import static com.mypractice.assistancetracker.util.CommonUtils.NUMERIC_CODE;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
/**
 * @author nasru
 *
 */
@Entity
@Table(name = COUNTRY_MASTER)
public class Country implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 209779289912751469L;
	@Id
	@Column(name = COUNTRY_CODE, length = LEN_3)
	private String countryCode;
	@Column(name = COUNTRY_NAME, length = LEN_50)
	private String countryName;
	@Column(name = ALPHA_2_CODE, length =LEN_2)
	private String alpha2Code;
	@Column(name = NUMERIC_CODE, length = LEN_3)
	private String numbericCode;
	@OneToMany(mappedBy =COUNTRY, fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<State> state;
	/**
	 * @return the state
	 */
	public Set<State> getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(Set<State> state) {
		this.state = state;
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
