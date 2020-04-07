/**
 * nasru
 * City.java
 * Apr 7, 2020
 */
package com.mypractice.assistancetracker.model;

import static com.mypractice.assistancetracker.util.CommonUtils.CITY;
import static com.mypractice.assistancetracker.util.CommonUtils.CITY_ALPHA_CODE;
import static com.mypractice.assistancetracker.util.CommonUtils.CITY_CODE;
import static com.mypractice.assistancetracker.util.CommonUtils.CITY_NAME;
import static com.mypractice.assistancetracker.util.CommonUtils.STATE_CODE;
import static com.mypractice.assistancetracker.util.CommonUtils.LEN_2;
import static com.mypractice.assistancetracker.util.CommonUtils.LEN_3;
import static com.mypractice.assistancetracker.util.CommonUtils.LEN_50;
import static com.mypractice.assistancetracker.util.CommonUtils.MASTER;
import static com.mypractice.assistancetracker.util.CommonUtils.UNDER_LINE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author nasru
 *
 */
@Entity
@Table(name =CITY+UNDER_LINE+MASTER)
public class City {

	@Id
	@Column(name = CITY_CODE, length= LEN_3)
	private String cityCode;
	@Column(name = CITY_NAME,  length= LEN_50)
	private String cityName;
	@Column(name = CITY_ALPHA_CODE,length = LEN_2)
	private String cityAlphaCOde;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = STATE_CODE)
    private State state;
	
	/**
	 * 
	 */
	public City() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param cityCode
	 * @param cityName
	 * @param cityAlphaCOde
	 * @param state
	 */
	public City(String cityCode, String cityName, String cityAlphaCOde, State state) {
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
	public State getState() {
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
	public void setState(State state) {
		this.state = state;
	}
	
}
