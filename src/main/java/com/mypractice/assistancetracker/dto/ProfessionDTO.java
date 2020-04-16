/**
 * nasru
 * ProfessionDTO.java
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
public class ProfessionDTO {
	private Integer professionId;
	@Pattern(regexp = ONLY_CHAR_PATTERN + START_DOLLAR, message = ONLY_CHAR_ALLOW)
	@Size(max = MST_LEN_100, min = LEN_3, message = INVALID_FIELD_SIZE)
	@NotBlank(message = FIELD_INVALID)
	private String professionName;
	private LocalDateTime createDateTime;
	private LocalDateTime updateDateTime;
	public String isNew;

	/**
	 * @return the professionName
	 */
	public String getProfessionName() {
		return professionName;
	}



	/**
	 * @param professionName the professionName to set
	 */
	public void setProfessionName(String professionName) {
		this.professionName = professionName;
	}



	/**
	 * @return the professionId
	 */
	public Integer getProfessionId() {
		return professionId;
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
	 * @param professionId the professionId to set
	 */
	public void setProfessionId(Integer professionId) {
		this.professionId = professionId;
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
