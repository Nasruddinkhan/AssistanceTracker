/**
 * nasru
 * PinCode.java
 * Apr 9, 2020
 */
package com.mypractice.assistancetracker.model;

import static com.mypractice.assistancetracker.util.CommonUtils.CITY_CODE;
import static com.mypractice.assistancetracker.util.CommonUtils.LEN_6;
import static com.mypractice.assistancetracker.util.CommonUtils.MASTER;
import static com.mypractice.assistancetracker.util.CommonUtils.PINCODE;
import static com.mypractice.assistancetracker.util.CommonUtils.PIN_CODE;
import static com.mypractice.assistancetracker.util.CommonUtils.PIN__CODE;
import static com.mypractice.assistancetracker.util.CommonUtils.UNDER_LINE;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * @author nasru
 *
 */
@Entity
@Table(name =PINCODE+UNDER_LINE+MASTER)
public class PinCode {

	@Id
	@Column(name = PIN_CODE, length= LEN_6)
	private String pinCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JoinColumn(name = CITY_CODE)
    private City city;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy =PIN__CODE, fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
	private List<Address> address;

	/**
	 * @return the pinCode
	 */
	public String getPinCode() {
		return pinCode;
	}

	/**
	 * @return the city
	 */
	public City getCity() {
		return city;
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
	public void setCity(City city) {
		this.city = city;
	}


	
	
}
