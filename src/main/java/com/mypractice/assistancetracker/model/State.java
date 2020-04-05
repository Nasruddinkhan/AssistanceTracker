/**
 * nasru
 * State.java
 * Apr 4, 2020
 */
package com.mypractice.assistancetracker.model;
import static com.mypractice.assistancetracker.util.CommonUtils.ALPHA_2_CODE;
import static com.mypractice.assistancetracker.util.CommonUtils.LEN_3;
import static com.mypractice.assistancetracker.util.CommonUtils.LEN_50;
import static com.mypractice.assistancetracker.util.CommonUtils.MASTER;
import static com.mypractice.assistancetracker.util.CommonUtils.STATE;
import static com.mypractice.assistancetracker.util.CommonUtils.STATE_CODE;
import static com.mypractice.assistancetracker.util.CommonUtils.STATE_NAME;
import static com.mypractice.assistancetracker.util.CommonUtils.UNDER_LINE;
import static com.mypractice.assistancetracker.util.CommonUtils.COUNTRY_CODE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.mypractice.assistancetracker.util.CommonUtils;
/**
 * @author nasru
 *
 */
@Entity
@Table(name =STATE+UNDER_LINE+MASTER)
public class State {
	@Id
	@Column(name = STATE_CODE,length = LEN_3)
	private String stateCode;
	@Column(name = STATE_NAME, length = LEN_50)
	private String stateName;
	@Column(name = ALPHA_2_CODE, length = CommonUtils.LEN_2)
	private String alpha2Code;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = COUNTRY_CODE)
    private Country country;
	
	/**
	 * @return the country
	 */
	public Country getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(Country country) {
		this.country = country;
	}
	/**
	 * @return the stateCode
	 */
	public String getStateCode() {
		return stateCode;
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
	 * @param stateCode the stateCode to set
	 */
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
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
}
