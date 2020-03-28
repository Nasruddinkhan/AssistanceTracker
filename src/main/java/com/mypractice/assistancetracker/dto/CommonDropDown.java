/**
 * nasru
 * CommonDropDown.java
 * Mar 28, 2020
 */
package com.mypractice.assistancetracker.dto;

/**
 * @author nasru
 *
 */
public class CommonDropDown {
	private String key;
	private String value;
	
	/**
	 * 
	 */
	public CommonDropDown() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param key
	 * @param value
	 */
	public CommonDropDown(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
