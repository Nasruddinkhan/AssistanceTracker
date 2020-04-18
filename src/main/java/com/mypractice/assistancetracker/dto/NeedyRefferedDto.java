/**
 * nasru
 * NeedyRefferedDto.java
 * Apr 16, 2020
 */
package com.mypractice.assistancetracker.dto;

import static com.mypractice.assistancetracker.util.CommonUtils.FIELD_INVALID;
import static com.mypractice.assistancetracker.util.CommonUtils.INVALID_FIELD_SIZE;
import static com.mypractice.assistancetracker.util.CommonUtils.LEN_6;
import static com.mypractice.assistancetracker.util.CommonUtils.LEN_10;
import static com.mypractice.assistancetracker.util.CommonUtils.MST_LEN_100;
import static com.mypractice.assistancetracker.util.CommonUtils.ONLY_CHAR_ALLOW;
import static com.mypractice.assistancetracker.util.CommonUtils.ONLY_CHAR_PATTERN;
import static com.mypractice.assistancetracker.util.CommonUtils.ONLY_DIGIT;
import static com.mypractice.assistancetracker.util.CommonUtils.ONLY_DIGIT_ALLOW;
import static com.mypractice.assistancetracker.util.CommonUtils.START_DOLLAR;

import java.time.LocalDateTime;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author nasru
 *
 */
public class NeedyRefferedDto {
	private Integer reffererId;
	@Pattern(regexp = ONLY_CHAR_PATTERN + START_DOLLAR, message = ONLY_CHAR_ALLOW)
	@Size(max =MST_LEN_100 , min =LEN_6 , message = INVALID_FIELD_SIZE)
	@NotBlank(message = FIELD_INVALID)
	private String 	reffereName;
	@NotBlank(message = FIELD_INVALID)
	@Size(max =LEN_10 , min =LEN_10 , message = INVALID_FIELD_SIZE)
	@Pattern(regexp = ONLY_DIGIT + START_DOLLAR, message = ONLY_DIGIT_ALLOW)
	private String 	refrerMobileNumber;
	@NotBlank(message = FIELD_INVALID)
	private String 	relationShipWithNeedy;
	private LocalDateTime createDateTime;
	private LocalDateTime updateDateTime;
	private String relationShipName;
	
	/**
	 * @return the relationShipName
	 */
	public String getRelationShipName() {
		return relationShipName;
	}
	/**
	 * @param relationShipName the relationShipName to set
	 */
	public void setRelationShipName(String relationShipName) {
		this.relationShipName = relationShipName;
	}
	public String isNew;
	
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
	 * @return the reffererId
	 */
	public Integer getReffererId() {
		return reffererId;
	}
	/**
	 * @return the reffereName
	 */
	public String getReffereName() {
		return reffereName;
	}
	/**
	 * @return the refrerMobileNumber
	 */
	public String getRefrerMobileNumber() {
		return refrerMobileNumber;
	}
	/**
	 * @return the relationShipWithNeedy
	 */
	public String getRelationShipWithNeedy() {
		return relationShipWithNeedy;
	}
	/**
	 * @param reffererId the reffererId to set
	 */
	public void setReffererId(Integer reffererId) {
		this.reffererId = reffererId;
	}
	/**
	 * @param reffereName the reffereName to set
	 */
	public void setReffereName(String reffereName) {
		this.reffereName = reffereName;
	}
	/**
	 * @param refrerMobileNumber the refrerMobileNumber to set
	 */
	public void setRefrerMobileNumber(String refrerMobileNumber) {
		this.refrerMobileNumber = refrerMobileNumber;
	}
	/**
	 * @param relationShipWithNeedy the relationShipWithNeedy to set
	 */
	public void setRelationShipWithNeedy(String relationShipWithNeedy) {
		this.relationShipWithNeedy = relationShipWithNeedy;
	}
}
