/**
 * nasru
 * ReasonDto.java
 * Apr 16, 2020
 */
package com.mypractice.assistancetracker.dto;

import static com.mypractice.assistancetracker.util.CommonUtils.FIELD_INVALID;
import static com.mypractice.assistancetracker.util.CommonUtils.INVALID_FIELD_SIZE;
import static com.mypractice.assistancetracker.util.CommonUtils.LEN_3;
import static com.mypractice.assistancetracker.util.CommonUtils.MST_LEN_100;
import static com.mypractice.assistancetracker.util.CommonUtils.ONLY_CHAR_ALLOW;
import static com.mypractice.assistancetracker.util.CommonUtils.ONLY_CHAR_PATTERN;
import static com.mypractice.assistancetracker.util.CommonUtils.START_DOLLAR;

import java.time.LocalDateTime;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author nasru
 *
 */
public class ReasonDto {
	private Integer reasonId;
	@Pattern(regexp = ONLY_CHAR_PATTERN + START_DOLLAR, message = ONLY_CHAR_ALLOW)
	@Size(max = MST_LEN_100, min = LEN_3, message = INVALID_FIELD_SIZE)
	@NotBlank(message = FIELD_INVALID)
	private String reasonName;
	private LocalDateTime createDateTime;
	private LocalDateTime updateDateTime;
	public String isNew;
	/**
	 * @return the reasonId
	 */
	public Integer getReasonId() {
		return reasonId;
	}
	/**
	 * @return the reasonName
	 */
	public String getReasonName() {
		return reasonName;
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
	 * @param reasonId the reasonId to set
	 */
	public void setReasonId(Integer reasonId) {
		this.reasonId = reasonId;
	}
	/**
	 * @param reasonName the reasonName to set
	 */
	public void setReasonName(String reasonName) {
		this.reasonName = reasonName;
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
	
}
