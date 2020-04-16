/**
 * nasru
 * Reason.java
 * Apr 16, 2020
 */
package com.mypractice.assistancetracker.model;

import static com.mypractice.assistancetracker.util.CommonUtils.ADD_DATE;
import static com.mypractice.assistancetracker.util.CommonUtils.EDIT_DATE;
import static com.mypractice.assistancetracker.util.CommonUtils.MST_LEN_100;
import static com.mypractice.assistancetracker.util.CommonUtils.REASON;
import static com.mypractice.assistancetracker.util.CommonUtils.REASON_ID;
import static com.mypractice.assistancetracker.util.CommonUtils.REASON_NAME;
import static com.mypractice.assistancetracker.util.CommonUtils.SEQ;
import static com.mypractice.assistancetracker.util.CommonUtils.MASTER;
import static com.mypractice.assistancetracker.util.CommonUtils.UNDER_LINE;
import static com.mypractice.assistancetracker.util.CommonUtils.MST_LEN_1;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * @author nasru
 *
 */
@Entity
@Table(name = REASON+UNDER_LINE+MASTER)
public class Reason {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = REASON + SEQ)
	@SequenceGenerator(name = REASON + SEQ, sequenceName = REASON_NAME+UNDER_LINE + SEQ , allocationSize = MST_LEN_1,initialValue =  MST_LEN_1)
	@Column(name = REASON_ID)
	private Integer reasonId;
	@Column(name = REASON_NAME, length = MST_LEN_100)
	private String reasonName;
	@Column(name = ADD_DATE)
	@CreationTimestamp
	private LocalDateTime createDateTime;
	@Column(name = EDIT_DATE)
	@UpdateTimestamp
	private LocalDateTime updateDateTime;
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
	

}
