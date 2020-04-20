/**
 * nasru
 * Address.java
 * Apr 20, 2020
 */
package com.mypractice.assistancetracker.model;

import static com.mypractice.assistancetracker.util.CommonUtils.ADDRESS;
import static com.mypractice.assistancetracker.util.CommonUtils.CITY_CODE;
import static com.mypractice.assistancetracker.util.CommonUtils.COUNTRY_CODE;
import static com.mypractice.assistancetracker.util.CommonUtils.INVALID_FIELD_SIZE;
import static com.mypractice.assistancetracker.util.CommonUtils.LEN_3;
import static com.mypractice.assistancetracker.util.CommonUtils.LEN_50;
import static com.mypractice.assistancetracker.util.CommonUtils.MASTER;
import static com.mypractice.assistancetracker.util.CommonUtils.MST_LEN_1;
import static com.mypractice.assistancetracker.util.CommonUtils.PIN_CODE;
import static com.mypractice.assistancetracker.util.CommonUtils.SEQ;
import static com.mypractice.assistancetracker.util.CommonUtils.STATE_CODE;
import static com.mypractice.assistancetracker.util.CommonUtils.UNDER_LINE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.mypractice.assistancetracker.util.CommonUtils;

/**
 * @author nasru
 *
 */
@Entity
@Table(name =ADDRESS+UNDER_LINE+MASTER)
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = ADDRESS + SEQ)
	@SequenceGenerator(name =  ADDRESS + SEQ, sequenceName = ADDRESS+UNDER_LINE + SEQ , allocationSize = MST_LEN_1,initialValue =  MST_LEN_1)
	@Column(name = CommonUtils.ADDRESS_ID)
	private Integer addressId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = COUNTRY_CODE)
	private Country country;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = STATE_CODE)
	private State state;
	@Column(name = CommonUtils.ADDRESS_LINE1, length = CommonUtils.LEN_200)
	private String address1;
	@Column(name = CommonUtils.ADDRESS_LINE2, length =CommonUtils.LEN_200 )
	private String address2;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = CITY_CODE)
	private City city;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = PIN_CODE)
	private PinCode pinCode;
	@Column(name  =CommonUtils.STREET, length =  LEN_50 )
	private String street;
	
	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}
	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	/**
	 * @return the addressId
	 */
	public Integer getAddressId() {
		return addressId;
	}
	/**
	 * @return the country
	 */
	public Country getCountry() {
		return country;
	}
	/**
	 * @return the state
	 */
	public State getState() {
		return state;
	}
	/**
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}
	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}
	/**
	 * @return the city
	 */
	public City getCity() {
		return city;
	}
	/**
	 * @return the pinCode
	 */
	public PinCode getPinCode() {
		return pinCode;
	}
	/**
	 * @param addressId the addressId to set
	 */
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(Country country) {
		this.country = country;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(State state) {
		this.state = state;
	}
	/**
	 * @param address1 the address1 to set
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(City city) {
		this.city = city;
	}
	/**
	 * @param pinCode the pinCode to set
	 */
	public void setPinCode(PinCode pinCode) {
		this.pinCode = pinCode;
	}
	
	

}
