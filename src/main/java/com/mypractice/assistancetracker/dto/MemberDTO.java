/**
 * nasru
 * MemberDTO.java
 * Apr 19, 2020
 */
package com.mypractice.assistancetracker.dto;

import static com.mypractice.assistancetracker.util.CommonUtils.EMAIL_INVALID_MSG;
import static com.mypractice.assistancetracker.util.CommonUtils.EMAIL_REGEX_PATTERN;
import static com.mypractice.assistancetracker.util.CommonUtils.FIELD_INVALID;
import static com.mypractice.assistancetracker.util.CommonUtils.INVALID_FIELD_SIZE;
import static com.mypractice.assistancetracker.util.CommonUtils.LEN_10;
import static com.mypractice.assistancetracker.util.CommonUtils.LEN_200;
import static com.mypractice.assistancetracker.util.CommonUtils.ONLY_CHAR_ALLOW;
import static com.mypractice.assistancetracker.util.CommonUtils.ONLY_CHAR_PATTERN;
import static com.mypractice.assistancetracker.util.CommonUtils.ONLY_DIGIT;
import static com.mypractice.assistancetracker.util.CommonUtils.ONLY_DIGIT_ALLOW;
import static com.mypractice.assistancetracker.util.CommonUtils.START_DOLLAR;
import static com.mypractice.assistancetracker.util.CommonUtils.LEN_50;
import static com.mypractice.assistancetracker.util.CommonUtils.LEN_3;
import static com.mypractice.assistancetracker.util.CommonUtils.MST_LEN_20;
import static com.mypractice.assistancetracker.util.CommonUtils.MST_LEN_100;
import java.time.LocalDateTime;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
/**
 * @author nasru
 *
 */
public class MemberDTO {
	private String memberId;
	@Pattern(regexp = ONLY_CHAR_PATTERN + START_DOLLAR, message = ONLY_CHAR_ALLOW)
	@NotBlank(message = FIELD_INVALID)
	@Size(max =LEN_50 , min =LEN_3 , message = INVALID_FIELD_SIZE)
	private String firstName;
	@Pattern(regexp = ONLY_CHAR_PATTERN + START_DOLLAR, message = ONLY_CHAR_ALLOW)
	@NotBlank(message = FIELD_INVALID)
	@Size(max =MST_LEN_20 , min =LEN_3 , message = INVALID_FIELD_SIZE)  
	private String lastName;
	@Pattern(regexp = ONLY_CHAR_PATTERN + START_DOLLAR, message = ONLY_CHAR_ALLOW)
	@NotBlank(message = FIELD_INVALID)
	@Size(max =MST_LEN_20 , min =LEN_3 , message = INVALID_FIELD_SIZE)
	private String nickName;
	@Pattern(regexp = ONLY_DIGIT + START_DOLLAR, message = ONLY_DIGIT_ALLOW)
	@NotBlank(message = FIELD_INVALID)
	@Size(max = LEN_10, min =LEN_10 , message = INVALID_FIELD_SIZE)
	private String contactNo;
	@Pattern(regexp = ONLY_DIGIT + START_DOLLAR, message = ONLY_DIGIT_ALLOW)
	@NotBlank(message = FIELD_INVALID)
	@Size(max =LEN_10 , min =LEN_10 , message = INVALID_FIELD_SIZE)
	private String cantactNo1;
	@Pattern(regexp = EMAIL_REGEX_PATTERN, message = EMAIL_INVALID_MSG)
	@NotBlank(message = FIELD_INVALID)
	@Size(max =MST_LEN_100 , min =LEN_10 , message = INVALID_FIELD_SIZE)
	private String emailId;
	@NotBlank(message = FIELD_INVALID)
	private String profession;
	@NotBlank(message = FIELD_INVALID)
	private String country;
	@NotBlank(message = FIELD_INVALID)
	private String state;
	@NotBlank(message = FIELD_INVALID)
	private String city;
	@NotBlank(message = FIELD_INVALID)
	private String pinCode;
	@NotBlank(message = FIELD_INVALID)
	@Size(max =LEN_50 , min =LEN_3 , message = INVALID_FIELD_SIZE)
	private String street;
	@NotBlank(message = FIELD_INVALID)
	@Size(max =LEN_200 , min =LEN_10 , message = INVALID_FIELD_SIZE)
	private String address1;
	@Size(max =LEN_200 , min =LEN_10 , message = INVALID_FIELD_SIZE)
	@NotBlank(message = FIELD_INVALID)
	private String address2;
	private String professionName;
	private String countryName;
	private String stateName;
	private String cityName;
	private LocalDateTime createDateTime;
	private LocalDateTime updateDateTime;
	public String isNew;
	private Integer addressId;
	
	/**
	 * @return the professionName
	 */
	public String getProfessionName() {
		return professionName;
	}
	/**
	 * @return the countryName
	 */
	public String getCountryName() {
		return countryName;
	}
	/**
	 * @return the stateName
	 */
	public String getStateName() {
		return stateName;
	}
	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}
	/**
	 * @param professionName the professionName to set
	 */
	public void setProfessionName(String professionName) {
		this.professionName = professionName;
	}
	/**
	 * @param countryName the countryName to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	/**
	 * @param stateName the stateName to set
	 */
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	/**
	 * @return the addressId
	 */
	public Integer getAddressId() {
		return addressId;
	}
	/**
	 * @param addressId the addressId to set
	 */
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	/**
	 * @return the createDateTime
	 */
	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}
	/**
	 * @return the updateDateTime
	 */
	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}
	/**
	 * @return the isNew
	 */
	public String getIsNew() {
		return isNew;
	}
	/**
	 * @param createDateTime the createDateTime to set
	 */
	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}
	/**
	 * @param updateDateTime the updateDateTime to set
	 */
	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
	/**
	 * @param isNew the isNew to set
	 */
	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}

	/**
	 * @return the memberId
	 */
	public String getMemberId() {
		return memberId;
	}
	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}
	/**
	 * @return the contactNo
	 */
	public String getContactNo() {
		return contactNo;
	}
	/**
	 * @return the cantactNo1
	 */
	public String getCantactNo1() {
		return cantactNo1;
	}
	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}
	/**
	 * @return the profession
	 */
	public String getProfession() {
		return profession;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @return the pinCode
	 */
	public String getPinCode() {
		return pinCode;
	}
	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
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
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @param nickName the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	/**
	 * @param contactNo the contactNo to set
	 */
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	/**
	 * @param cantactNo1 the cantactNo1 to set
	 */
	public void setCantactNo1(String cantactNo1) {
		this.cantactNo1 = cantactNo1;
	}
	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	/**
	 * @param profession the profession to set
	 */
	public void setProfession(String profession) {
		this.profession = profession;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @param pinCode the pinCode to set
	 */
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
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
}
